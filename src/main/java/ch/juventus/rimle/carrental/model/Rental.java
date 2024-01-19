package ch.juventus.rimle.carrental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * The persistent rental object
 */
@Entity
@Data
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    @JsonIgnore
    private Car car;

    @ManyToOne
    private Customer customer;

    public Rental(Date startDate, Date endDate, Car car, Customer customer) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.customer = customer;
    }
}
