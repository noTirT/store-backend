package com.tom.selling.orderitem.entity;

import com.tom.selling.artpiece.entity.ArtPieceDto;
import com.tom.selling.order.entity.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {

    private Long id;

    private ArtPieceDto artPieceDto;

    private OrderDto orderDto;

    private int amount;

    public static OrderItemDto of(OrderItemDbo orderItemDbo) {
        return OrderItemDto.builder()
                .id(orderItemDbo.getId())
                .artPieceDto(ArtPieceDto.of(orderItemDbo.getArtPiece()))
                .orderDto(OrderDto.of(orderItemDbo.getOrder()))
                .amount(orderItemDbo.getAmount())
                .build();
    }
}
