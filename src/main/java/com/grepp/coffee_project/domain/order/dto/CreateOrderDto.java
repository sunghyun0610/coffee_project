package com.grepp.coffee_project.domain.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CreateOrderDto {
    private long productIds;//상품 넘버 , 한번에 한 음료만 선택가능 -> 중복 선택하면 cnt도 리스트로 만들어야 할거 같아서?
    private String productName;//뭘 주문했는지 -> 상품 pk로 대체가능한가?
    private int quantity;//얼마나 주문했는지
    private String email;//주문자 이메일이다
    private String address;
    private String postCode;

//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;


}
//주문할 떄 뭐 필요하지?