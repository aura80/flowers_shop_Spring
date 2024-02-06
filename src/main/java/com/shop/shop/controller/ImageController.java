package com.shop.shop.controller;

import com.shop.shop.model.Image;
import com.shop.shop.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/saveImage")
    public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file) throws IOException {
        String savedImage = imageService.saveImage(file);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Image saved successfully")
                .body(savedImage);
    }

    @GetMapping("/getImageByName/{imageName}")
    public ResponseEntity<byte[]> getImageByName(@PathVariable String imageName) {
        byte[] imageByName = imageService.getImageByName(imageName);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageByName);
    }

    @GetMapping("/getImageById/{image_id}")
    public ResponseEntity<Image> getImageById(@PathVariable("image_id") Long imageId) {
        Image imageById= imageService.getImageById(imageId);

        return  new ResponseEntity<>(imageById, HttpStatus.OK);
    }

    @DeleteMapping("/deleteImage/{image_id}")
    public ResponseEntity<Void> deleteImage(@PathVariable("image_id") Long imageId) {
        imageService.deleteImageById(imageId);

        return ResponseEntity.noContent()
                .header("Message", "Image deleted successfully")
                .build();
    }
}
