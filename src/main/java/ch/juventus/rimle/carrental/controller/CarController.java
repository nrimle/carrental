package ch.juventus.rimle.carrental.controller;

import ch.juventus.rimle.carrental.model.Car;
import ch.juventus.rimle.carrental.service.CarService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1")
public class CarController {

    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * Gets all cars from the database
     * @return list of cars
     */
    @GetMapping("/car")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    /**
     * Creates a new car
     * @param car car object to be created
     * @return the newly created car object
     */
    @PostMapping("/car")
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.CREATED);
    }

    /**
     * Delete an existing car
     * @param id the id of the car to be deleted
     */
    @DeleteMapping("/car/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @CrossOrigin(methods = RequestMethod.DELETE)
    public void deleteCar(@PathVariable("id") Integer id) {
        carService.deleteCar(id);
    }
}
