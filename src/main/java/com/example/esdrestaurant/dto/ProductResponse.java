package com.example.esdrestaurant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
public record ProductResponse(
        @JsonProperty("id")
        long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("price")
        double price
) {
}
