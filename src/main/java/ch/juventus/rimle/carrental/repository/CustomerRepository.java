package ch.juventus.rimle.carrental.repository;

import ch.juventus.rimle.carrental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository to perform CRUD operations on customer
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
