package com.tom.selling.order.control.repository;

import com.tom.selling.order.entity.orderitem.OrderItemDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItemDbo, Long> {
    List<OrderItemDbo> findByOrderId(Long order_id);
}
