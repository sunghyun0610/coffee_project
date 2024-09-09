package com.grepp.coffee_project.domain.order.converter;

import com.grepp.coffee_project.domain.order.dto.CreateOrderDto;
import com.grepp.coffee_project.domain.order.entity.Order;
import com.grepp.coffee_project.domain.order.entity.OrderItem;

public class OrderConverter {
    public static Order toEntity(CreateOrderDto createOrderDto) {
        Order order = new Order();
        order.setEmail(createOrderDto.getEmail());
        order.setAddress(createOrderDto.getAddress());
        System.out.println("Address: " + createOrderDto.getAddress());
        order.setPostcode(createOrderDto.getPostCode());
        order.setOrder_status("주문완료");
        return order;
    }
}
