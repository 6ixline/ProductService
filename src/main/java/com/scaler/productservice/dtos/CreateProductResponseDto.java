package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    private Long Id;
    private String title;
    private double price;
    private String description;
    private String ImageUrl;
    private String category;

    public static CreateProductResponseDto fromProduct(Product product){
        CreateProductResponseDto response = new CreateProductResponseDto();
        response.setId(product.getId());
        response.setTitle(product.getTitle());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setCategory(product.getCategory());
        response.setImageUrl(product.getImageUrl());
        return response;
    }
}
