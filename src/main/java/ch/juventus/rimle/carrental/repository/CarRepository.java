package ch.juventus.rimle.carrental.repository;

import ch.juventus.rimle.carrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JPA repository to perform CRUD operations on  cars
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    /**
     * Finds all cars in the database
     * @return list of cars
     */
    List<Car> findAllByOrderByIdAsc();

    /**
     * Find one car
     * @param id the id of the car
     * @return single car object
     */
    Car findCarById(Integer id);

}
