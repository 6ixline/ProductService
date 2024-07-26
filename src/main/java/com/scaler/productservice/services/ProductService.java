package com.scaler.productservice.services;

import com.scaler.productservice.models.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long Id);

    Product deleteProduct(Long Id);
}
