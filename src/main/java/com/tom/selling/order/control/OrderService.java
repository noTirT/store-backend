package com.tom.selling.order.control;

import com.tom.selling.order.entity.OrderDto;
import com.tom.selling.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements DataService<OrderDto> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAll() {
        return null;
    }

    @Override
    public OrderDto getById(Long id) {
        return null;
    }

    @Override
    public void createNew(OrderDto newItem) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(OrderDto updatedItem) {

    }
}
