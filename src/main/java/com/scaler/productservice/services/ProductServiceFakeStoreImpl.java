package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.scaler.productservice.dtos.FakeStoreCreateProductResponseDto;
import com.scaler.productservice.models.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service("fakeStoreProductServiceImpl")
public class ProductServiceFakeStoreImpl implements ProductService{

    private RestTemplate restTemplate;

    public ProductServiceFakeStoreImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto requestDto = new FakeStoreCreateProductRequestDto();
        requestDto.setTitle(product.getTitle());
        requestDto.setCategory(product.getCategory());
        requestDto.setPrice(product.getPrice());
        requestDto.setImage(product.getImageUrl());
        requestDto.setDescription(product.getDescription());

        FakeStoreCreateProductResponseDto responseDto = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                requestDto,
                FakeStoreCreateProductResponseDto.class
        );

        Product product1 = new Product();
        product1.setId(responseDto.getId());
        product1.setTitle(responseDto.getTitle());
        product1.setPrice(responseDto.getPrice());
        product1.setDescription(responseDto.getDescription());
        product1.setImageUrl(responseDto.getImage());
        product1.setCategory(responseDto.getCategory());
        return product1;
    }

    public Product getProductById(Long Id){
        FakeStoreCreateProductResponseDto responseDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + Id.toString(),
                FakeStoreCreateProductResponseDto.class
        );
        Product product = new Product();
        product.setId(responseDto.getId());
        product.setTitle(responseDto.getTitle());
        product.setPrice(responseDto.getPrice());
        product.setDescription(responseDto.getDescription());
        product.setCategory(responseDto.getCategory());
        product.setImageUrl(responseDto.getImage());
        return product;
    }

    @Override
    public Product deleteProduct(Long Id) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<FakeStoreCreateProductResponseDto> entity = new HttpEntity<FakeStoreCreateProductResponseDto>(headers);

        FakeStoreCreateProductResponseDto responseDto = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + Id,
                HttpMethod.DELETE,
                entity,
                FakeStoreCreateProductResponseDto.class
        ).getBody();
        return responseDto.toProduct();
    }
}
