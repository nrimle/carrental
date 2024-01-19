package ch.juventus.rimle.carrental.service;

import ch.juventus.rimle.carrental.model.Address;
import ch.juventus.rimle.carrental.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    /**
     * Create new address
     * @param address address to be created
     * @return newly created address
     */
    public Address createAddress(Address address) {
        return repository.save(address);
    }
}
