package com.shop.shop.dto;

import com.shop.shop.model.Client;
import com.shop.shop.model.enums.OrderStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class OrderDto {
    @NotNull
    private Long id;

    @NotBlank(message = "name field is mandatory")
    private String name;

    @NotNull(message = "order number field is mandatory")
    @Min(value = 999, message = "order number must contain 4 digits")
    private int orderNo;

    @NotNull(message = "quantity field is mandatory")
    private double quantity;

    @NotBlank(message = "status field is mandatory")
    private OrderStatus status;

    @NotBlank(message = "date of creation field is mandatory")
    private LocalDate creationDate;

    @NotBlank(message = "client field is mandatory")
    private Client client;

    public OrderDto(String name, int orderNo, int quantity, OrderStatus status, LocalDate creationDate, Client client) {
        this.name = name;
        this.orderNo = orderNo;
        this.quantity = quantity;
        this.status = status;
        this.creationDate = creationDate;
        this.client = client;
    }

    // to use it with CommandLineRunner
    public OrderDto(String name, int orderNo, int quantity, OrderStatus status, LocalDate creationDate) {
        this.name = name;
        this.orderNo = orderNo;
        this.quantity = quantity;
        this.status = status;
        this.creationDate = creationDate;
    }
}
