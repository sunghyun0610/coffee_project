package com.grepp.coffee_project.domain.product.dto;

import com.grepp.coffee_project.domain.order.entity.OrderItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ResponseDto {

    private long productId;

    private String productName;

    private String category;

    private Long price;//bigint == java에서 long


    private String description;  // 기본값을 NULL로 설정

    private List<OrderItem> orderItems;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

//직접 엔티티를 반환하지 않고 응답DTO를 사용하는 이유
/*
* DTO는 클라이언트에게 필요한 데이터를 가공하여 전달하고, 불필요한 데이터나 민감한 정보를 숨기며, 시스템의 유지보수성을 높이는 데 도움이 됩니다.
엔티티는 비즈니스 로직과 데이터베이스의 구조에 맞게 설계되며, 이를 그대로 API 응답으로 사용하면 보안, 유지보수성, 성능 등 다양한 측면에서 문제가 발생할 수 있습니다.
따라서 서비스 계층에서 엔티티를 직접 반환하기보다는, DTO를 사용해 필요한 정보만 추출하여 반환하는 방식이 더 안전하고 유연한 방법입니다.*/
