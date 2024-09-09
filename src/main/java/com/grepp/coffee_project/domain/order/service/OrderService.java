package com.grepp.coffee_project.domain.order.service;

import com.grepp.coffee_project.domain.order.converter.OrderItemConverter;
import com.grepp.coffee_project.domain.order.converter.OrderConverter;
import com.grepp.coffee_project.domain.order.dto.CreateOrderDto;
import com.grepp.coffee_project.domain.order.dto.OrderResponseDto;
import com.grepp.coffee_project.domain.order.dto.ReadOrderDto;
import com.grepp.coffee_project.domain.order.entity.Order;
import com.grepp.coffee_project.domain.order.entity.OrderItem;
import com.grepp.coffee_project.domain.order.repository.OrderItemRepository;
import com.grepp.coffee_project.domain.order.repository.OrderRepository;
import com.grepp.coffee_project.domain.product.entity.Product;
import com.grepp.coffee_project.domain.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    OrderRepository orderRepository;
    OrderItemRepository orderItemRepository;
    ProductRepository productRepository;
    @Autowired//이건 생략가능
    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository){
        this.orderRepository=orderRepository;
        this.orderItemRepository=orderItemRepository;
        this.productRepository=productRepository;
    }

    public OrderResponseDto makeOrder(CreateOrderDto createOrderDto){
        //주문을 해보자
        Order order=OrderConverter.toEntity(createOrderDto);
        orderRepository.save(order);//주문을 먼저 저장을 해야지 중간테이블인 OrderItem이 생성될 수 있다.

        Optional<Product> optionalProduct = productRepository.findById(createOrderDto.getProductIds());//상품 id로 조회해서 어떤 상품 주문했는지 저장하기

        if (optionalProduct.isPresent()) {
            OrderItem orderItem = OrderItemConverter.toOrderItem(createOrderDto, optionalProduct.get(), order);
            orderItemRepository.save(orderItem);

            // Order와 OrderItem 정보를 포함한 OrderResponseDto 생성 및 반환
            return OrderResponseDto.builder()
                    .orderId(order.getOrder_id())
                    .email(order.getEmail())
                    .address(order.getAddress())
                    .postcode(order.getPostcode())
                    .orderStatus(order.getOrder_status())
                    .productName(optionalProduct.get().getProduct_name())
                    .price(optionalProduct.get().getPrice())
                    .quantity(orderItem.getQuantity())
                    .build();
        } else {
            throw new EntityNotFoundException("Product not found for ID: " + createOrderDto.getProductIds());
        }
    }
//
//    public ReadOrderDto readOrder(ReadOrderDto readOrderDto){
//        //이메일이 오면 그걸로 모두 조회해서 총주문목록을 알아내는 것
//    }
}
