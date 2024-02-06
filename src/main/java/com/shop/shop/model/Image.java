package com.shop.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "image_name")
    private String name;

    @Column(name = "image_type")
    private String imageType;

    @Column(name = "image_url")
    private String imageUrl;

    @Lob
    @Column(name = "image_imageData", unique = false, nullable = false, length = 100000)
    private byte[] imageData;
}
