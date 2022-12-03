package com.tom.selling.order.control.repository;

import com.tom.selling.order.entity.order.OrderDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends JpaRepository<OrderDbo, Long> {
}
