package com.grepp.coffee_project.domain.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
//주문한 주문내역을 읽어오는 Dto입니다.
public class ReadOrderDto {
    private long sum;//총 금액
    private Map<String,Integer> products; // 상품 이름과 수량을 저장하는 맵
    private String email;
    private String address;
    private String postcode;
}
