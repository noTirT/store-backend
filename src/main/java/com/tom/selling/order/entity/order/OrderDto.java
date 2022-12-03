package com.tom.selling.order.entity.order;

import com.tom.selling.order.entity.orderitem.OrderItemDbo;
import com.tom.selling.order.entity.orderitem.OrderItemDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long id;
    private String customerEmail;
    private boolean completed;
    private Long dateOrderedAt;
    private Float total;
    private List<OrderItemDto> orderItems;

    public static OrderDto of(OrderDbo orderDbo) {
        return OrderDto.builder()
                .id(orderDbo.getId())
                .customerEmail(orderDbo.getCustomerEmail())
                .completed(orderDbo.isCompleted())
                .dateOrderedAt(orderDbo.getOrderedAtTimestamp())
                .total(orderDbo.getTotal())
                .build();
    }

    public static OrderDto of(OrderDbo orderDbo, List<OrderItemDbo> orderItems) {
        return OrderDto.builder()
                .id(orderDbo.getId())
                .customerEmail(orderDbo.getCustomerEmail())
                .completed(orderDbo.isCompleted())
                .dateOrderedAt(orderDbo.getOrderedAtTimestamp())
                .total(orderDbo.getTotal())
                .orderItems(orderItems.stream().map(OrderItemDto::of).collect(Collectors.toList()))
                .build();
    }

}
