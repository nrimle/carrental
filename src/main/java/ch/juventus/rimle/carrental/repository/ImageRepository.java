package ch.juventus.rimle.carrental.repository;

import ch.juventus.rimle.carrental.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository to perform CRUD operations on images
 */
public interface ImageRepository extends JpaRepository<Image, Integer> {

    /**
     * Find one image
     * @param id the id of the image
     * @return single image object
     */
    Image findImageById(Integer id);
}
