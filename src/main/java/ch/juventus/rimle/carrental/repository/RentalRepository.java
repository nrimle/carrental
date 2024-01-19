package ch.juventus.rimle.carrental.repository;

import ch.juventus.rimle.carrental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * JPA repository to perform CRUD operations on rentals
 */
@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

    /**
     * Find all rentals
     * @return list of rentals
     */
    List<Rental> findAllByOrderByIdAsc();

}
