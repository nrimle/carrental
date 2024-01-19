package ch.juventus.rimle.carrental.repository;

import ch.juventus.rimle.carrental.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository to perform CRUD operations on  addresses
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
