package com.example.esdrestaurant.mapper;


import com.example.esdrestaurant.dto.ProductRequest;
import com.example.esdrestaurant.dto.ProductResponse;
import com.example.esdrestaurant.entity.Product;
import org.springframework.stereotype.Service;
@Service
public class ProductMapper {
    public Product toProduct(ProductRequest product) {
        return Product.builder()
                .name(product.name())
                .price(product.price())
                .build();
    }
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
