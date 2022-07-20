package com.tom.selling.orderitem.control;

import com.tom.selling.orderitem.entity.OrderItemDto;
import com.tom.selling.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService implements DataService<OrderItemDto> {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItemDto> getAll() {
        return null;
    }

    @Override
    public OrderItemDto getById(Long id) {
        return null;
    }

    @Override
    public void createNew(OrderItemDto newItem) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(OrderItemDto updatedItem) {

    }
}
