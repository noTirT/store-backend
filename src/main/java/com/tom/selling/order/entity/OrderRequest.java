package com.tom.selling.order.entity;

import com.tom.selling.orderitem.entity.OrderItemRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private String customerEmail;
    private Long orderedAtTimestamp;
    private List<OrderItemRequest> orderItems;
}
