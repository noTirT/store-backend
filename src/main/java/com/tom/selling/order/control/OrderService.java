package com.tom.selling.order.control;

import com.tom.selling.artpiece.control.ArtPieceService;
import com.tom.selling.artpiece.entity.ArtPieceDbo;
import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.order.entity.OrderDbo;
import com.tom.selling.order.entity.OrderDto;
import com.tom.selling.order.entity.OrderRequest;
import com.tom.selling.orderitem.control.OrderItemRepository;
import com.tom.selling.orderitem.entity.OrderItemDbo;
import com.tom.selling.orderitem.entity.OrderItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ArtPieceService artPieceService;

    public List<OrderDto> getAll() {
        return StreamSupport
                .stream(orderRepository.findAll().spliterator(), false)
                .map(OrderDto::of)
                .collect(Collectors.toList());
    }

    public OrderDto getById(Long id) {
        return OrderDto.of(orderRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
    }

    public void createNew(OrderRequest request) {
        OrderDbo orderDbo = new OrderDbo();
        orderDbo.setCustomerEmail(request.getCustomerEmail());
        orderDbo.setOrderedAtTimestamp(request.getOrderedAtTimestamp());

        Float total = 0F;
        for(OrderItemRequest temp: request.getOrderItems()){
            total += temp.getAmount() * artPieceService.getById(temp.getItemID()).getPrice();
        }
        orderDbo.setTotal(total);
        orderDbo.setCompleted(false);

        final OrderDbo orderDboFinal = orderRepository.save(orderDbo);

        request.getOrderItems().forEach(orderItemRequest -> {
            OrderItemDbo temp = new OrderItemDbo();
            temp.setAmount(orderItemRequest.getAmount());
            temp.setOrder(orderDboFinal);
            temp.setArtPiece(ArtPieceDbo.of(artPieceService.getById(orderItemRequest.getItemID())));
            orderItemRepository.save(temp);
        });
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public void update(OrderDto updatedItem) {
        orderRepository.save(OrderDbo.of(updatedItem));
    }
}
