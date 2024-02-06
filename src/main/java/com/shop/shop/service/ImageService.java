package com.shop.shop.service;

import com.shop.shop.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    String saveImage(MultipartFile file) throws IOException;
    byte[] getImageByName(String name);
    Image getImageById(Long id);
    void deleteImageById(Long id);
}
