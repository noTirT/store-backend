package com.tom.selling.order.entity.order;

import com.tom.selling.order.entity.orderitem.OrderItemResponse;
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
public class OrderResponse {
    private Long id;
    private String customerEmail;
    private boolean completed;
    private Long dateOrderedAt;
    private Float total;
    private List<OrderItemResponse> orderItems;

    public static OrderResponse of(OrderDto dto) {
        return OrderResponse.builder()
                .id(dto.getId())
                .customerEmail(dto.getCustomerEmail())
                .completed(dto.isCompleted())
                .dateOrderedAt(dto.getDateOrderedAt())
                .total(dto.getTotal())
                .orderItems(dto.getOrderItems().stream().map(OrderItemResponse::of).collect(Collectors.toList()))
                .build();
    }
}
