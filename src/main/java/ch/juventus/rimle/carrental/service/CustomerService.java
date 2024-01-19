package ch.juventus.rimle.carrental.service;

import ch.juventus.rimle.carrental.model.Address;
import ch.juventus.rimle.carrental.model.Customer;
import ch.juventus.rimle.carrental.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    private final AddressService addressService;

    public CustomerService(CustomerRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    /**
     * Creates a new customer
     * @param customer customer object
     * @return newly created customer object
     */
    public Customer createCustomer(Customer customer) {
        // creates address of customer if set and not already persistent
        if (customer.getBillingAddress() != null && customer.getBillingAddress().getId() == null) {
            Address address = addressService.createAddress(customer.getBillingAddress());
            customer.setBillingAddress(address);
        }
        return repository.save(customer);
    }
}
