package ch.juventus.rimle.carrental.service;

import ch.juventus.rimle.carrental.repository.ImageRepository;
import ch.juventus.rimle.carrental.model.Image;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.springframework.core.io.Resource;
import java.nio.file.Files;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Slf4j
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository repository) {
        this.imageRepository = repository;
    }

    /**
     * Uploads a new image
     * @param file image file
     * @return id of image
     * @throws IOException needs to get bytes of file
     */
    public Integer uploadImage(MultipartFile file) throws IOException {
        // creates a compressed version of the image
        Image compressedImage = new Image();
        compressedImage.setImageData(compressImage(file.getBytes()));
        // saves compressed image in database
        Image image = imageRepository.save(compressedImage);
        return image.getId();
    }

    /**
     * Gets existing image
     * @param id id of the image
     * @return bytes of image
     * @throws IOException might fetch default image from filesystem
     */
    @Transactional
    public byte[] getImage(Integer id) throws IOException {
        // tries to find image in database
        Image dbImage = imageRepository.findImageById(id);
        // if image is not found, returns a default image
        if (dbImage == null) {
            Resource resource = new ClassPathResource("static/car_default.jpg");
            return Files.readAllBytes(resource.getFile().toPath());
        }
        // returns decompressed image from database
        return decompressImage(dbImage.getImageData());
    }

    /**
     * Compresses image file
     * @param data image bytes
     * @return compressed image bytes
     */
    public static byte[] compressImage(byte[] data) {

        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception e) {
            log.info("failed to compress image with error: {}", e.getLocalizedMessage());
            return null;
        }
        return outputStream.toByteArray();
    }

    /**
     * Decompresses image file
     * @param data compressed image bytes
     * @return decompressed image bytes
     */
    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception e) {
            log.info("failed to decompress image with error: {}", e.getLocalizedMessage());
            return null;
        }
        return outputStream.toByteArray();
    }
}
