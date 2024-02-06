package com.shop.shop.service.impl;

import com.shop.shop.exceptions.NotFoundException;
import com.shop.shop.model.Image;
import com.shop.shop.repository.ImageRepository;
import com.shop.shop.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
//@RequiredArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    private final String FILE_PATH = "C:\\images\\upload\\";

    @Override
    public String saveImage(MultipartFile file) throws IOException {
        log.info("---> Saving the image: {} <---", file.getOriginalFilename());

        String storeMessage = null;

        String filePath = FILE_PATH + file.getOriginalFilename();

        Image files = Image
                .builder()
                .name(file.getOriginalFilename())
                .imageType(file.getContentType())
                .imageUrl(filePath)
                .imageData(file.getBytes())
                .build();

        files = imageRepository.save(files);

        if (files.getId() != null) {
            storeMessage = "File " + file.getOriginalFilename() + " successfully uploaded into DB";
        }

        return storeMessage;
    }

    @Override
    public byte[] getImageByName(String name) {
        log.info("---> Retrieving image by name: {} <---", name);
        return imageRepository.findByName(name).getImageData();
    }

    @Override
    public Image getImageById(Long id) {
        log.info("---> Retrieving image by ID: {} <---", id);
        return imageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Image with id: " + id + " was not found"));
    }

    @Override
    public void deleteImageById(Long id) {
        log.info("---> Deleting image by ID: {} <---", id);
        imageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Image not found by id %s", id)));

        imageRepository.deleteById(id);
    }
}
