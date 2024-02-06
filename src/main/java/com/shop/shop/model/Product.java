package com.shop.shop.model;

import com.shop.shop.model.enums.ProductCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(name = "product_description", nullable = false)
    private String description;

    @Column(name = "product_price", nullable = false)
    @NotNull(message = "Price is required")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category", nullable = false)
    private ProductCategory category;
}
