package com.grepp.coffee_project.domain.product.entity;

import com.grepp.coffee_project.domain.order.entity.OrderItem;
import com.grepp.coffee_project.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// 나중에 binart로 바꾸자
    private long product_id;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Long price;//bigint == java에서 long

    @Column(columnDefinition = "VARCHAR(500) DEFAULT NULL")
    private String description;  // 기본값을 NULL로 설정

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;


}
//Order-OrderProduct 양방향 관계 설정
//
//주문은 주문 목록과 부모 자식 관계를 맺는다고 생각하여 양방향 관계로 지정하였다.
//Product-OrderProduct 단방향 관계 설정
//
//상품과 주문상품에 대해서는 주문 상품은 상품을 알아야 하지만 상품은 주문 상품에 대해 알 필요가 없다고 여겨져서 단방향 관계로 설정하였다.