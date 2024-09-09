package com.grepp.coffee_project.domain.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCoffeeDto {
    private long price;
    private String description;
    private String productName;
    private String category;
}
