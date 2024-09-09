package com.grepp.coffee_project.domain.order.converter;

import com.grepp.coffee_project.domain.order.dto.CreateOrderDto;
import com.grepp.coffee_project.domain.order.entity.Order;
import com.grepp.coffee_project.domain.order.entity.OrderItem;
import com.grepp.coffee_project.domain.product.entity.Product;

public class OrderItemConverter {
    public static OrderItem toOrderItem(CreateOrderDto dto, Product product, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setProduct(product);
        orderItem.setPrice(product.getPrice());
        orderItem.setCategory(product.getCategory());
        orderItem.setOrder(order);
        return orderItem;
    }
}
