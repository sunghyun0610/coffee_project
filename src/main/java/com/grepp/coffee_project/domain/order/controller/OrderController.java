package com.grepp.coffee_project.domain.order.controller;

import com.grepp.coffee_project.domain.order.dto.CreateOrderDto;
import com.grepp.coffee_project.domain.order.dto.OrderResponseDto;
import com.grepp.coffee_project.domain.order.entity.Order;
import com.grepp.coffee_project.domain.order.entity.OrderItem;
import com.grepp.coffee_project.domain.order.repository.OrderItemRepository;
import com.grepp.coffee_project.domain.order.repository.OrderRepository;
import com.grepp.coffee_project.domain.order.service.OrderService;
import com.grepp.coffee_project.domain.product.entity.Product;
import com.grepp.coffee_project.domain.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // Controller + responsebody
@RequestMapping("/api/v1")
//주문
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<?> makerOrder(@RequestBody CreateOrderDto createOrderDto){
        //주문을 해보자
        OrderResponseDto orderResponseDto=orderService.makeOrder(createOrderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDto);

    }
//    @GetMapping("/order")
//    public ResponseEntity<?> selectOrder(String email){
//        //이메일을 받으면 이에대한 주문목록을 조회해서 가온나
//    }


}
