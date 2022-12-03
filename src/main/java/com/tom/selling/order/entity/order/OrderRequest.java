package com.tom.selling.order.entity.order;

import com.tom.selling.order.entity.orderitem.OrderItemRequest;
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
    private List<OrderItemRequest> orderItems;
}
