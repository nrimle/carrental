package ch.juventus.rimle.carrental.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * The rental object sent by the frontend
 */
@Data
@ToString
public class RentalObject {

    @NotNull(message = "value mustn't be null")
    @Positive(message = "value must be positive")
    private int carId;

    @NotNull(message = "value mustn't be null")
    @FutureOrPresent(message = "value must be in the future")
    private Date startDate;

    @NotNull(message = "value mustn't be null")
    @Future(message = "value must be in the future")
    private Date endDate;

    @NotNull(message = "value mustn't be null")
    private Customer customer;
}
