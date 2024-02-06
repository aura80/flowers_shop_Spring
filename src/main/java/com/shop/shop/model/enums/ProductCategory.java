package com.shop.shop.model.enums;

public enum ProductCategory {
    BOUQUETS("Perishable"),
    GARDEN("Garden"),
    HOUSE("House"),
    ORNAMENTAL("Clothes"),
    SEEDS("Jewelry")
    ;

    private final String value;


    ProductCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
