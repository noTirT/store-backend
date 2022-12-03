package com.tom.selling.order.entity.orderitem;


import com.tom.selling.artpiece.entity.ArtPieceDto;
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

    public static OrderItemResponse of(OrderItemDto dto) {
        return OrderItemResponse.builder()
                .id(dto.getId())
                .artPieceResponse(ArtPieceResponse.of(dto.getArtPieceDto()))
                .amount(dto.getAmount()).build();
    }

    public static OrderItemResponse of(OrderItemDbo dbo) {
        return OrderItemResponse.of(OrderItemDto.of(dbo));
    }
}
