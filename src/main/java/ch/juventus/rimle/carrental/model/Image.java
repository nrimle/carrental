package ch.juventus.rimle.carrental.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * The image of a car
 */
@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(length = 1000)
    private byte[] imageData;

}
