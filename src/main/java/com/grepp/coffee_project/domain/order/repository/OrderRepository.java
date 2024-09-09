package com.grepp.coffee_project.domain.order.repository;

import com.grepp.coffee_project.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    //여기서 email로 주문 조회를 해야겠네?
//    List<Order> findAllByEmail(String email);
    @Query("SELECT o FROM Order o JOIN FETCH o.orderItems oi JOIN FETCH oi.product WHERE o.email = :email")
    List<Order> findOrdersByEmailWithOrderItems(@Param("email") String email);

}
