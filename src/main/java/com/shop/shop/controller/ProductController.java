package com.shop.shop.controller;


import com.shop.shop.dto.ProductDto;
import com.shop.shop.model.Product;
import com.shop.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.saveProduct(productDto);
        return ResponseEntity.status((HttpStatus.CREATED))
                .header("Message", "Client has been created successfully").body(savedProduct);
    }

    @PostMapping("/saveAllProducts")
    public ResponseEntity<Void> saveAllProducts(@RequestBody List<Product> products) {
        productService.saveAllProducts(products);
        return ResponseEntity.noContent()
                .header("Message", "All products added successfully").build();
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> allProductsList = productService.getAllProducts();
        return ResponseEntity.ok(allProductsList);
    }

    @GetMapping("/getProductById/{product_id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("product_id") Long productId) {
        ProductDto productDtoById = productService.getProductById(productId);
        return new ResponseEntity<>(productDtoById, HttpStatus.OK);
    }

    @PutMapping("/updateProductById/{product_id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable("product_id") Long productId,
                                                        @RequestBody ProductDto productDto) {
        ProductDto updatedProduct = productService.updateProductById(productDto, productId);
        return ResponseEntity.status(HttpStatus.OK).header("Message", "Product updated by id: "
                + productId).body(updatedProduct);
    }

    @DeleteMapping("/deleteProductById/{product_id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("product_id") Long productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().header("Message","Product deleted by id: " + productId)
                .build();
    }
}
