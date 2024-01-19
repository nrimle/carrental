package ch.juventus.rimle.carrental.service;

import ch.juventus.rimle.carrental.model.Car;
import ch.juventus.rimle.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all cars
     * @return list of cars
     */
    public List<Car> getCars() {
        return repository.findAllByOrderByIdAsc();
    }

    /**
     * Get one car by id
     * @param id the id of the car
     * @return single car object
     */
    public Car getCarById(Integer id) {
        return repository.findCarById(id);
    }

    /**
     * Creates a new car
     * @param car car object
     * @return newly created car object
     */
    public Car createCar(Car car) {
        return repository.save(car);
    }

    /**
     * Deletes a car
     * @param id id of car
     */
    public void deleteCar(Integer id) {
        repository.deleteById(id);
    }
}
