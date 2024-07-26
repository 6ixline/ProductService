package com.scaler.productservice.services;

import com.scaler.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("productServiceDbImpl")
public class ProductServiceDbImpl implements ProductService{
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product getProductById(Long Id) {
        return null;
    }

    @Override
    public Product deleteProduct(Long Id) {
        return null;
    }
}
