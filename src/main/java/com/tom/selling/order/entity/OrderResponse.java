package com.tom.selling.order.entity;


import com.tom.selling.orderitem.entity.OrderItemResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private String customerEmail;
    private boolean fullFilled;
    private Long dateOrderedAt;
    private Float total;
    private List<OrderItemResponse> orderItems;
}
