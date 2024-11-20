package com.example.esdrestaurant.service;

import com.example.esdrestaurant.dto.ProductRequest;
import com.example.esdrestaurant.entity.Product;
import com.example.esdrestaurant.mapper.ProductMapper;
import com.example.esdrestaurant.repo.ProductRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepository;
    private final ProductMapper productMapper;
    public List<Product> getProductsByValueRange(double minValue, double maxValue) {
        return  productRepository.findByValue(minValue, maxValue);
    }
    public String createProduct( ProductRequest products) {
        Product product = productMapper.toProduct(products);
        productRepository.save(product);
        return "Product created";
    }
}