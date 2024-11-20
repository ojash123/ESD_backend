package com.example.esdrestaurant.controller;

import com.example.esdrestaurant.dto.ProductRequest;
import com.example.esdrestaurant.entity.Product;
import com.example.esdrestaurant.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getProductsByValueRange(
            @RequestParam("min") double minValue,
            @RequestParam("max") double maxValue) {
        return ResponseEntity.ok( productService.getProductsByValueRange(minValue, maxValue));
    }
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequest product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }
}
