package com.tom.selling.orderitem.control;

import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.orderitem.entity.OrderItemDbo;
import com.tom.selling.orderitem.entity.OrderItemDto;
import com.tom.selling.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OrderItemService implements DataService<OrderItemDto> {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItemDto> getAll() {
        return StreamSupport
                .stream(orderItemRepository.findAll().spliterator(), false)
                .map(OrderItemDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDto getById(Long id) {
        return OrderItemDto.of(orderItemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
    }

    @Override
    public void createNew(OrderItemDto newItem) {
        orderItemRepository.save(OrderItemDbo.of(newItem));
    }

    @Override
    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        orderItemRepository.deleteAll();
    }

    @Override
    public void update(OrderItemDto updatedItem) {
        orderItemRepository.save(OrderItemDbo.of(updatedItem));
    }
}
