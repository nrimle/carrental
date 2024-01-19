package ch.juventus.rimle.carrental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * The address of the customer
 */
@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "value mustn't be null")
    @Column
    private String street;

    @NotNull(message = "value mustn't be null")
    @Column
    private String houseNumber;

    @NotNull(message = "value mustn't be null")
    @Positive(message = "value must be positive")
    @Min(value = 1000, message = "value too small")
    @Max(value = 99999, message = "value too large")
    @Column
    private Integer zipCode;

    @NotNull(message = "value mustn't be null")
    @Column
    private String city;

    @OneToOne
    @JsonIgnore
    private Customer customer;

}
