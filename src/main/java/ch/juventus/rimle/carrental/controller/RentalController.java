package ch.juventus.rimle.carrental.controller;

import ch.juventus.rimle.carrental.model.*;
import ch.juventus.rimle.carrental.service.CarService;
import ch.juventus.rimle.carrental.service.CustomerService;
import ch.juventus.rimle.carrental.service.RentalService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RentalController {

    RentalService rentalService;
    CustomerService customerService;
    CarService carService;

    public RentalController(RentalService rentalService, CustomerService customerService, CarService carService) {
        this.rentalService = rentalService;
        this.customerService = customerService;
        this.carService = carService;
    }

    /**
     * Gets all rentals
     * @return list of rentals
     */
    @GetMapping("/rental")
    public ResponseEntity<List<Rental>> getAllRentals() {
        return new ResponseEntity<>(rentalService.getRentals(), HttpStatus.OK);
    }

    /**
     * Creates new rental
     * @param rental rental object to be created
     * @return the newly created rental object
     */
    @PostMapping("/rental")
    public ResponseEntity<Rental> createRental(@Valid @RequestBody RentalObject rental) {
        Customer customer;
        try {
            customer = customerService.createCustomer(rental.getCustomer());
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Car car = carService.getCarById(rental.getCarId());
        car.setRentals(null);
        Rental newRental = new Rental(rental.getStartDate(), rental.getEndDate(), car, customer);
        return new ResponseEntity<>(rentalService.createRental(newRental), HttpStatus.CREATED);
    }
}
