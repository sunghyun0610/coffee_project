package com.grepp.coffee_project.domain.order.repository;

import com.grepp.coffee_project.domain.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    //fintByEmail
}
