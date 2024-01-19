package ch.juventus.rimle.carrental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * The customer that rents a car
 */
@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "value mustn't be null")
    @Column
    private String firstName;

    @NotNull(message = "value mustn't be null")
    @Column
    private String lastName;

    @NotNull(message = "value mustn't be null")
    @Past(message = "value must be in the past")
    @Column
    private Date dateOfBirth;

    @NotNull(message = "value mustn't be null")
    @OneToOne
    private Address billingAddress;

    @OneToMany
    @JsonIgnore
    List<Rental> rentals;

    @Column
    private String licenceNumber;

    @Column
    private Boolean verifiedLicence = false;
}
