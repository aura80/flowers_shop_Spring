package com.shop.shop.service.impl;

import com.shop.shop.dto.OrderDto;
import com.shop.shop.exceptions.NotFoundException;
import com.shop.shop.model.Order;
import com.shop.shop.repository.OrderRepository;
import com.shop.shop.service.OrderService;
import com.shop.shop.utils.DualEntityDtoConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        log.info("---> Saving order <---");
        Order orderEntity = DualEntityDtoConverter.toEntity(orderDto);
        Order savedOrderEntity = orderRepository.save(orderEntity);
        return DualEntityDtoConverter.toDto(savedOrderEntity);
    }
    @Override
    public void saveAllOrders(List<Order> orders) {
        log.info("---> Retrieving all the orders <---");
        orderRepository.saveAll(orders);
    }
    @Override
    public List<OrderDto> getAllOrders() {
        log.info("---> Retrieving all the orders <---");
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(DualEntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public OrderDto getOrderById(Long id) {
        log.info("---> Retrieving order by ID: {} <---", id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order with id: " + id + " was not found"));
        return DualEntityDtoConverter.toDto(order);
    }
    @Override
    public OrderDto updateOrderById(OrderDto orderDto, Long id) {
        log.info("---> Updating order by ID: {} <---", id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order with id: " + id + " was not found"));

        order.setName(orderDto.getName());
        order.setOrderNo(orderDto.getOrderNo());
        order.setCreationDate(orderDto.getCreationDate());
        order.setQuantity(orderDto.getQuantity());
        order.setStatus(orderDto.getStatus());

        Order updatedOrder = orderRepository.save(order);

        return DualEntityDtoConverter.toDto(updatedOrder);
    }

    @Override
    public void deleteOderById(Long id) {
        log.info("---> Deleting order by ID: {} <---", id);
        orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order with id: " + id + " was not found"));

        orderRepository.deleteById(id);
    }
}
