package com.tom.selling.order.entity;

import com.tom.selling.orderitem.entity.OrderItemDto;
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
    private boolean fullFilled;
    private Long dateOrderedAt;
    private Float total;
    private List<OrderItemDto> orderItems;

    public static OrderDto of(OrderDbo orderDbo) {
        return OrderDto.builder()
                .id(orderDbo.getId())
                .customerEmail(orderDbo.getCustomeremail())
                .fullFilled(orderDbo.isFullfilled())
                .dateOrderedAt(orderDbo.getOrderedattimestamp())
                .total(orderDbo.getTotal())
                .orderItems(orderDbo.getOrderItems().stream().map(OrderItemDto::of).collect(Collectors.toList())).build();
    }

}
