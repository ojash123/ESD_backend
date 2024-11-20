package com.example.esdrestaurant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record ProductRequest(
        @JsonProperty("name")
        @NotBlank(message = "Name is missing")
        String name,
        @JsonProperty("price")
        @NotNull(message = "Provide the price")
        double price
) {
}