package com.tom.selling.order.control;

import com.tom.selling.order.entity.OrderDbo;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderDbo, Long> {
}
