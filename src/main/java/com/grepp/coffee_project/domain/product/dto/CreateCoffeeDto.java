package com.grepp.coffee_project.domain.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCoffeeDto {
    private String product_name;
    private String category;
    private Long price;
    private String description;
}
