package com.shop.shop.utils;

import com.shop.shop.dto.*;
import com.shop.shop.model.*;
import org.modelmapper.ModelMapper;

import java.util.List;

public class DualEntityDtoConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    // Client - Dto to Entity conversion
    public static Client toEntity(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }

    // Client - Entity to Dto conversion
    public static ClientDto toDto(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }

    // Admin - Dto to Entity conversion
    public static Admin toEntity(AdminDto adminDto) {
        return modelMapper.map(adminDto, Admin.class);
    }

    // Admin - Entity to Dto conversion
    public static AdminDto toDto(Admin admin) {
        return modelMapper.map(admin, AdminDto.class);
    }

    // Order - Dto to Entity conversion
    public static Order toEntity(OrderDto orderDto) {
        return modelMapper.map(orderDto, Order.class);
    }

    // Order - Entity to Dto conversion
    public static OrderDto toDto(Order order) {
        return modelMapper.map(order, OrderDto.class);
    }

    // Product - Dto to Entity conversion
    public static Product toEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    // Product - Entity to Dto conversion
    public static ProductDto toDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
//    // Image - Dto to Entity conversion
//    public static Image toEntity(ImageDto imageDto) {
//        return modelMapper.map(imageDto, Image.class);
//    }
//
//    // Image - Entity to Dto conversion
//    public static ImageDto toDto(Image image) {
//        return modelMapper.map(image, ImageDto.class);
//    }

    // Image - Dto to Entity conversion
//    public static List<Image> toEntity(Byte[] bait) {
//        return modelMapper.map(bait, List<Image>.class);
//    }

    // Image - Entity to Dto conversion
//    public static Byte[] toByte(Image image) {
//        return modelMapper.map(image, Byte[].class);
//    }

