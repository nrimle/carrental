package ch.juventus.rimle.carrental.model;


import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Test
    public void testValidationNoError() {
        Address address = new Address();
        address.setStreet("Wassergasse");
        address.setHouseNumber("42B");
        address.setZipCode(9500);
        address.setCity("Wil");
        assertTrue(validator.validate(address).isEmpty());
    }

    @Test
    public void testValidationNullValue() {
        Address address = new Address();
        address.setStreet(null);
        address.setHouseNumber("42B");
        address.setZipCode(9500);
        address.setCity("Wil");
        assertFalse(validator.validate(address).isEmpty());
    }
}
