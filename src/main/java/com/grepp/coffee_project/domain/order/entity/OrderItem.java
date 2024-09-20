package com.grepp.coffee_project.domain.order.entity;

import com.grepp.coffee_project.domain.product.entity.Product;
import com.grepp.coffee_project.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @ManyToOne//외래키는 다수쪽에 위치 == 연관관계의 주인이다
    @JoinColumn(name = "order_id" ,nullable = false)
    private Order order;

    @ManyToOne//ManyToone은 Eager가 기본값
    @JoinColumn(name = "product_id" ,nullable = false)
    private Product product;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private long price;
    @Column(nullable = false)
    private int quantity;
}
//@JoinColumn은 외래 키 관계를 설정할 때 사용하므로, 별도로 @Column 어노테이션을 붙이지 않습니다.
// 즉, @JoinColumn 자체가 컬럼 역할을 하며, 추가로 @Column을 사용할 필요가 없습니다.

//ManyToOne
//설명: 여러 개의 엔티티가 하나의 엔티티와 연관되는 관계입니다.
//        예를 들어, 여러 개의 주문(OrderItem)이 하나의 고객(Customer)에 속할 수 있습니다. 하나의 고객은 여러 주문을 가질 수 있지만, 각 주문은 하나의 고객에게만 속할 수 있습니다.
//데이터베이스 측면: 외래 키는 다수의 엔티티에서 하나의 엔티티를 가리킵니다.
//        매핑: 외래 키를 가진 엔티티에 @ManyToOne을 설정하여, 다수의 엔티티가 하나의 엔티티를 참조하게 됩니다.


