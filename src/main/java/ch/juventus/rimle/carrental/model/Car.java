package ch.juventus.rimle.carrental.model;

import ch.juventus.rimle.carrental.enums.CarType;
import ch.juventus.rimle.carrental.enums.Transmission;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * The car object to be rented
 */
@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer id;

    @NotNull(message = "value mustn't be null")
    @Size(min = 2, max = 35, message = "Invalid length")
    @Column
    private String name;

    @NotNull(message = "value mustn't be null")
    @Column
    private CarType type;

    @NotNull(message = "value mustn't be null")
    @Column
    private Transmission transmission;

    @NotNull(message = "value mustn't be null")
    @Positive(message = "value must be positive")
    @Column
    private BigDecimal costPerDay;

    @NotNull(message = "value mustn't be null")
    @Positive(message = "value must be positive")
    @Column
    private Integer seats;

    @NotNull(message = "value mustn't be null")
    @Column
    private String image;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "car")
    private List<Rental> rentals;

    /**
     * Overrides lombok setter
     * @param type car type as string
     */
    public void setType(String type) {
        this.type = CarType.fromString(type);
    }

    /**
     * Overrides lombok setter
     * @param transmission transmission as string
     */
    public void setTransmission(String transmission) {
        this.transmission = Transmission.fromString(transmission);
    }
}
