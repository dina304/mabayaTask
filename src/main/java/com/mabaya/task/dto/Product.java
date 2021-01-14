package com.mabaya.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class Product {
    private UUID id;
    private String title;
    private int categoryId;
    private double price;

    public Product(String title, int categoryId, double price) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.categoryId = categoryId;
        this.price = price;
    }
}
