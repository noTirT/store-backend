package com.tom.selling.orderitem.control;

import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.orderitem.entity.OrderItemDbo;
import com.tom.selling.orderitem.entity.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItemDto> getAll() {
        return StreamSupport
                .stream(orderItemRepository.findAll().spliterator(), false)
                .map(OrderItemDto::of)
                .collect(Collectors.toList());
    }

    public OrderItemDto getById(Long id) {
        return OrderItemDto.of(orderItemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
    }

    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }

    public void update(OrderItemDto updatedItem) {
        orderItemRepository.save(OrderItemDbo.of(updatedItem));
    }
}
