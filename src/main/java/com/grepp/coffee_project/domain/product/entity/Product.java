package com.grepp.coffee_project.domain.product.entity;

import com.grepp.coffee_project.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity extends BaseEntity {

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




}
