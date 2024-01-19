package ch.juventus.rimle.carrental.model;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RentalObjectTest {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Test
    public void testValidationNoError() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        RentalObject rentalObject = new RentalObject();
        rentalObject.setCarId(5);
        rentalObject.setStartDate(tomorrow);
        rentalObject.setEndDate(tomorrow);
        rentalObject.setCustomer(new Customer());
        assertTrue(validator.validate(rentalObject).isEmpty());
    }

    @Test
    public void testValidationEndDateNotFuture() {
        RentalObject rentalObject = new RentalObject();
        rentalObject.setCarId(5);
        rentalObject.setStartDate(new Date());
        rentalObject.setEndDate(new Date());
        rentalObject.setCustomer(new Customer());
        assertFalse(validator.validate(rentalObject).isEmpty());
    }
}
