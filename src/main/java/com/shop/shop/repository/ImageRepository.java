package com.shop.shop.repository;

import com.shop.shop.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByName(String name);
}

// it will select over whatever we put after findBy in the name of the method
// and it will compare this with the name of the argument
// it will search for an Image and it will compare the Name with the name
