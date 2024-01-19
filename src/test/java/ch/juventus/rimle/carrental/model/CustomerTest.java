package ch.juventus.rimle.carrental.model;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Address address = new Address();

    @BeforeEach
    void initAll() {
        this.address.setStreet("Wassergasse");
        this.address.setHouseNumber("42B");
        this.address.setZipCode(9500);
        this.address.setCity("Wil");
    }

    @Test
    public void testValidationNoError() {
        Customer customer = new Customer();
        customer.setFirstName("Hans");
        customer.setLastName("Meier");
        customer.setDateOfBirth(new Date(120, Calendar.DECEMBER, 18));
        customer.setBillingAddress(this.address);
        assertTrue(validator.validate(customer).isEmpty());
    }

    @Test
    public void testValidationMissingAddress() {
        Customer customer = new Customer();
        customer.setFirstName("Hans");
        customer.setLastName("Meier");
        customer.setDateOfBirth(new Date(120, Calendar.DECEMBER, 18));
        customer.setBillingAddress(null);
        assertFalse(validator.validate(customer).isEmpty());
    }
}
