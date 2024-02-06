package com.shop.shop.dto;

import com.shop.shop.model.enums.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

    @NotNull
    private Long id;

    @NotBlank(message = "name field is mandatory")
    private String name;

    @NotBlank(message = "description field is mandatory")
    private String description;

    @NotNull(message = "price field is mandatory")
    private double price;

    @NotBlank(message = "category field is mandatory")
    private ProductCategory category;

    public ProductDto(String name, String description, double price, ProductCategory category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}
