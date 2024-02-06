package com.shop.shop.controller;

import com.shop.shop.dto.OrderDto;
import com.shop.shop.model.Order;
import com.shop.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto) {
        OrderDto savedOrder = orderService.saveOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Order was created successfully").body(savedOrder);
    }

    @PostMapping("/saveAllOrders")
    public ResponseEntity<Void> saveAllOrders(@RequestBody List<Order> orders) {
        orderService.saveAllOrders(orders);
        return ResponseEntity.noContent().header("Message","All orders added successfully")
                .build();
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/getOrderById/{order_id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("order_id") Long orderId) {
        OrderDto orderById = orderService.getOrderById(orderId);
        return new ResponseEntity<>(orderById, HttpStatus.OK);
    }

    @PutMapping("/updateOrderById/{order_id}")
    public ResponseEntity<OrderDto> updateOrderById(@PathVariable("order_id") Long orderId,
                                                    @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.updateOrderById(orderDto, orderId);
        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Order updated successfully").body(updatedOrder);
    }

    @DeleteMapping("/deleteOderById/{order_id}")
    public ResponseEntity<Void> deleteOderById(@PathVariable("order_id") Long orderId) {
        orderService.deleteOderById(orderId);
        return ResponseEntity.noContent()
                .header("Message", "Order deleted successfully").build();
    }
}
