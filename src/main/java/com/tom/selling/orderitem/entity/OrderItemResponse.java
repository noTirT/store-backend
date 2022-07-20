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
    private float totalPrice;
}
