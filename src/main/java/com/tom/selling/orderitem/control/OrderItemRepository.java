package com.tom.selling.orderitem.control;

import com.tom.selling.orderitem.entity.OrderItemDbo;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItemDbo, Long> {
}
