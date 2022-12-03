package com.tom.selling.order.entity.orderitem;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemRequest {
    private int amount;
    private Long itemID;
}
