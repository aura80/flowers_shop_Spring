package com.shop.shop.service.impl;

import com.shop.shop.dto.ProductDto;
import com.shop.shop.exceptions.NotFoundException;
import com.shop.shop.model.Product;
import com.shop.shop.repository.ProductRepository;
import com.shop.shop.service.ProductService;
import com.shop.shop.utils.DualEntityDtoConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        log.info("---> Saving products <---");
        Product productEntity = DualEntityDtoConverter.toEntity(productDto);
        Product savedProductEntity = productRepository.save(productEntity);

        return DualEntityDtoConverter.toDto(savedProductEntity);
    }

    @Override
    public void saveAllProducts(List<Product> products) {
        log.info("---> Retrieving all the orders <---");

        productRepository.saveAll(products);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        log.info("---> Retrieving all the products <---");
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(DualEntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        log.info("---> Retrieving product by ID: {} <---", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with id: " + id + " was not found"));

        return DualEntityDtoConverter.toDto(product);
    }

    @Override
    public ProductDto updateProductById(ProductDto productDto, Long id) {
        log.info("---> Updating product by ID: {} <---", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with id: " + id + " was not found"));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());

        Product updatedProduct = productRepository.save(product);

        return DualEntityDtoConverter.toDto(updatedProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        log.info("---> Deleting product by ID: {} <---", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with id: " + id + " was not found"));

        productRepository.delete(product);
    }
}
