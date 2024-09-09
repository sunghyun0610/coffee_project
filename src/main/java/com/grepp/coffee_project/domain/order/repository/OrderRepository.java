package com.grepp.coffee_project.domain.order.repository;

import com.grepp.coffee_project.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    //여기서 email로 주문 조회를 해야겠네?
}
