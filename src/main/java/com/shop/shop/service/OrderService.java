package com.shop.shop.service;

import com.shop.shop.dto.OrderDto;
import com.shop.shop.model.Order;

import java.util.List;

public interface OrderService {

    OrderDto saveOrder(OrderDto orderDto);
    void saveAllOrders(List<Order> orders);
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(Long id);
    OrderDto updateOrderById(OrderDto orderDto, Long id);
    void deleteOderById(Long id);
}
