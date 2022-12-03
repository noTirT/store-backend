package com.tom.selling.order.control.service;

import com.tom.selling.exception.EmptyOrderException;
import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.order.control.repository.OrderItemRepository;
import com.tom.selling.order.entity.orderitem.OrderItemDbo;
import com.tom.selling.order.entity.orderitem.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository repository;

    public List<OrderItemDto> getOrdersByOrderId(Long orderId) {
        var temp = repository.findByOrderId(orderId);
        if (temp.size() <= 0) throw new EmptyOrderException(orderId);
        return temp.stream().map(OrderItemDto::of).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
