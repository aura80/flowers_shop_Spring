package com.shop.shop.model.enums;

public enum OrderStatus {
    PENDING("Pending"),
    CANCELLED("Cancelled"),
    REFUNDED("Refunded"),
    COMPLETED("Completed"),
    SHIPPED("Shipped")
    ;

    private final String value;


    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
