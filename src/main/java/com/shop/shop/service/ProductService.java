package com.shop.shop.service;

import com.shop.shop.dto.ProductDto;
import com.shop.shop.model.Product;

import java.util.List;

public interface ProductService {

    ProductDto saveProduct(ProductDto productDto);
    void saveAllProducts(List<Product> products);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto updateProductById(ProductDto productDto, Long id);
    void deleteProductById(Long id);
}
