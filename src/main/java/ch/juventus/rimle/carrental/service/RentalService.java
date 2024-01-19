package ch.juventus.rimle.carrental.service;

import ch.juventus.rimle.carrental.model.Rental;
import ch.juventus.rimle.carrental.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private final RentalRepository repository;

    public RentalService(RentalRepository repository) {
        this.repository = repository;
    }

    /**
     * Gets all rentals
     * @return list of rentals
     */
    public List<Rental> getRentals() {
        return repository.findAllByOrderByIdAsc();
    }

    /**
     * Creates new rental
     * @param rental rental object
     * @return newly created rental object
     */
    public Rental createRental(Rental rental) {
        return repository.save(rental);
    }
}
