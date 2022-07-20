package com.tom.selling.order.control;

import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.order.entity.OrderDbo;
import com.tom.selling.order.entity.OrderDto;
import com.tom.selling.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OrderService implements DataService<OrderDto> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAll() {
        return StreamSupport
                .stream(orderRepository.findAll().spliterator(), false)
                .map(OrderDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getById(Long id) {
        return OrderDto.of(orderRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
    }

    @Override
    public void createNew(OrderDto newItem) {
        orderRepository.save(OrderDbo.of(newItem));
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }

    @Override
    public void update(OrderDto updatedItem) {
        orderRepository.save(OrderDbo.of(updatedItem));
    }
}
