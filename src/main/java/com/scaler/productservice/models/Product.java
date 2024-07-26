package com.scaler.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long Id;
    private String title;
    private double price;
    private String description;
    private String ImageUrl;
    private String category;
}
