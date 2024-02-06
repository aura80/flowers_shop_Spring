package com.shop.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.shop.model.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_name", nullable = false)
    private String name;

    @Column(name = "order_no", nullable = false, unique = true)
    @NotNull(message = "Order no. is required")
    @Min(value = 999, message = "order number must contain 4 digits")
    private int orderNo;

    @Column(name = "order_quantity", nullable = false)
    @NotNull(message = "Quantity is required")
    private double quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", length = 20, nullable = false)
    private OrderStatus status;

    @Column(name = "order_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // to use it with CommandLineRunner - without client
    public Order(long id, String name, int orderNo, int quantity,
                 OrderStatus status, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.orderNo = orderNo;
        this.quantity = quantity;
        this.status = status;
        this.creationDate = creationDate;
    }
}
