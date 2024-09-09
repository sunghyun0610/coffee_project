package com.grepp.coffee_project.domain.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailCoffeeDto {
    private long productId;//커피 아이디
    private String image;
    private String productName;
    private String category;
    private String description;
    private long price;
}
