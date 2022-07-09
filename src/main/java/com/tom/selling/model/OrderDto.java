package com.tom.selling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private String customerEmail;
    private boolean fullFilled;
    private Long dateOrderedAt;
    private Float total;
    private List<OrderItemDto> orderItems;

}
