package ch.juventus.rimle.carrental.model;

import ch.juventus.rimle.carrental.enums.CarType;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Test
    public void testValidationNoError() {
        Car car = new Car();
        car.setName("Fiat");
        car.setType("HATCHBACK");
        car.setTransmission("MANUAL");
        car.setCostPerDay(BigDecimal.valueOf(51.25));
        car.setSeats(5);
        car.setImage("/image/23");
        assertTrue(validator.validate(car).isEmpty());
    }

    @Test
    public void testValidationNameTooShort() {
        Car car = new Car();
        car.setName("F");
        car.setType("HATCHBACK");
        car.setTransmission("MANUAL");
        car.setCostPerDay(BigDecimal.valueOf(51.25));
        car.setSeats(5);
        car.setImage("/image/23");
        assertFalse(validator.validate(car).isEmpty());
    }
}
