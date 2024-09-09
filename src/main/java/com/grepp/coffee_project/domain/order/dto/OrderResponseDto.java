package com.grepp.coffee_project.domain.order.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderResponseDto {
    private Long orderId;
    private String email;
    private String address;
    private String postcode;
    private String orderStatus;
    private String productName;
    private String category;
    private int quantity;
    private long price;
}
