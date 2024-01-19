package ch.juventus.rimle.carrental.controller;

import ch.juventus.rimle.carrental.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1")
public class ImageController {

    ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    /**
     * Gets an image from the database
     * @param id the id of the image
     * @return image data
     * @throws IOException might fetch default image from filesystem
     */
    @GetMapping("/image/{id}")
    public ResponseEntity<?> getImage(@PathVariable("id") Integer id) throws IOException {
        byte[] image = imageService.getImage(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }

    /**
     * Uploads a new image
     * @param file the image to be saved
     * @return the id of the image
     * @throws IOException needs to get bytes of file
     */
    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        Integer id = imageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(id);
    }
}
