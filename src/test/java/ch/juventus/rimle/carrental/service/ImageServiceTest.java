package ch.juventus.rimle.carrental.service;

import org.junit.jupiter.api.Test;

import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ImageServiceTest {

    @Test
    public void testImageCompression() {
        byte[] bytes = HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d");
        byte[] compressed = ImageService.compressImage(bytes);
        byte[] expected = new byte[]{120, -38, 123, -32, 127, 65, -31, -107, 85, -90, -64, -94, 27, 28, 12, -38, 6, 6, 115, 1, 63, 50, 6, 103};
        assertArrayEquals(expected, compressed);
    }

    @Test
    public void testImageDecompression() {
        byte[] bytes = new byte[]{120, -38, 123, -32, 127, 65, -31, -107, 85, -90, -64, -94, 27, 28, 12, -38, 6, 6, 115, 1, 63, 50, 6, 103};
        byte[] decompressed = ImageService.decompressImage(bytes);
        byte[] expected = HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d");
        assertArrayEquals(expected, decompressed);
    }
}
