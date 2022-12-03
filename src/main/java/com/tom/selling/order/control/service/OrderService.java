package com.tom.selling.order.control.service;

import com.tom.selling.artpiece.control.ArtPieceService;
import com.tom.selling.artpiece.control.ArtRepository;
import com.tom.selling.artpiece.entity.ArtPieceDbo;
import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.order.control.repository.OrderItemRepository;
import com.tom.selling.order.control.repository.OrderRepository;
import com.tom.selling.order.entity.order.OrderDbo;
import com.tom.selling.order.entity.order.OrderDto;
import com.tom.selling.order.entity.order.OrderRequest;
import com.tom.selling.order.entity.orderitem.OrderItemDbo;
import com.tom.selling.order.entity.orderitem.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ArtPieceService artPieceService;
    private final ArtRepository artRepository;

    public List<OrderDto> getAll() {
        return orderRepository.findAll().stream()
                .map(dbo -> OrderDto.of(dbo, orderItemRepository.findByOrderId(dbo.getId())))
                .collect(Collectors.toList());
    }

    public OrderDto getById(Long id) {
        var temp = OrderDto.of(orderRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
        temp.setOrderItems(orderItemRepository.findByOrderId(temp.getId()).stream().map(OrderItemDto::of).collect(Collectors.toList()));
        return temp;
    }

    public void createNew(OrderRequest request) {
        var total = request.getOrderItems().stream().reduce(
                0f, (subtotal, element) -> subtotal + element.getAmount() * artPieceService.getById(element.getItemID()).getPrice(), Float::sum);

        final OrderDbo orderDboFinal = orderRepository.save(OrderDbo.builder()
                .customerEmail(request.getCustomerEmail())
                .orderedAtTimestamp(new Date().getTime())
                .completed(false)
                .total(total)
                .build());

        request.getOrderItems().forEach(orderItemRequest -> orderItemRepository.save(
                        new OrderItemDbo(
                                orderItemRequest.getAmount(),
                                orderDboFinal,
                                artRepository.findById(orderItemRequest.getItemID()).orElseThrow(() -> new ItemNotFoundException(orderItemRequest.getItemID())))
                )
        );
    }

    public void update(OrderRequest updatedItem, Long id) {
        var order = orderRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        order.setCustomerEmail(updatedItem.getCustomerEmail());
        order.setOrderedAtTimestamp(new Date().getTime());

        orderRepository.save(order);
    }
}
