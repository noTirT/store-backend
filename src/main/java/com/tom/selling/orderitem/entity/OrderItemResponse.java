package com.tom.selling.orderitem.entity;


import com.tom.selling.artpiece.entity.ArtPieceResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemResponse {
    private Long id;
    private ArtPieceResponse artPieceResponse;
    private int amount;

    public static OrderItemResponse of(OrderItemDto dto){
        return OrderItemResponse.builder()
                .id(dto.getId())
                .artPieceResponse(ArtPieceResponse.of(dto.getArtPieceDto()))
                .amount(dto.getAmount()).build();
    }
}
