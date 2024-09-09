package com.grepp.coffee_project.domain.order.entity;

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
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String postcode;

    @Column(nullable = false)
    private String order_status;

    @OneToMany(mappedBy = "order" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;
}
//OneToMany
//설명: 하나의 엔티티가 여러 개의 엔티티와 연관되는 관계입니다. 이는 ManyToOne의 반대 방향 관계로 볼 수 있습니다.
//예를 들어, 하나의 고객(Customer)은 여러 개의 주문(OrderItem)을 가질 수 있습니다. 각 주문은 고객에 속하지만, 고객은 여러 주문을 가질 수 있습니다.
//데이터베이스 측면: 하나의 엔티티가 다수의 다른 엔티티에 참조됩니다. 보통 외래 키는 다수 쪽에 저장됩니다.
//매핑: @OneToMany는 기본적으로 다수 쪽 엔티티에 있는 외래 키와 연결됩니다. mappedBy 속성을 사용해 반대쪽 엔티티에서 외래 키를 설정합니다.