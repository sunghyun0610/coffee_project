package com.grepp.coffee_project.domain.product.dto;

import lombok.Getter;
import lombok.Setter;

//전체조회 할때 보여줄 데이터
@Getter
@Setter
public class ReadCoffeeDto {
    private long productId;//커피 아이디
    private String image;
    private String productName;
}
