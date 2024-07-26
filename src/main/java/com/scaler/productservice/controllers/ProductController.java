package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.dtos.CreateProductResponseDto;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductServiceImpl") ProductService productService){
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto productData){
        Product product = productService.createProduct(productData.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public void getAllProducts() {

    }

    @GetMapping("/{id}")
    public CreateProductResponseDto getSingleProduct(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return CreateProductResponseDto.fromProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }

    public void updateProduct() {}

    public void replaceProduct() {}
}
