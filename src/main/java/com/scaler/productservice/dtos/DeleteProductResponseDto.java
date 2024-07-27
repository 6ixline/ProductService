package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteProductResponseDto {
    private Long Id;
    private String title;
    private double price;
    private String description;
    private String ImageUrl;
    private String category;

    public static DeleteProductResponseDto fromProduct(Product product){
        DeleteProductResponseDto responseDto = new DeleteProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setCategory(product.getCategory());
        responseDto.setPrice(product.getPrice());
        responseDto.setDescription(product.getDescription());
        responseDto.setImageUrl(product.getImageUrl());

        return responseDto;
    }

}
