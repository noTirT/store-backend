package com.tom.selling.orderitem.entity;

import com.tom.selling.artpiece.entity.ArtPieceDbo;
import com.tom.selling.order.entity.OrderDbo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ORDERITEM")
@Builder
public class OrderItemDbo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "orderitem_id_seq")
    @Column(name = "ID")
    private Long id;

    @Column(name = "AMOUNT")
    private int amount;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID", nullable = false, referencedColumnName = "ID")
    private OrderDbo order;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID", nullable = false, referencedColumnName = "ID")
    private ArtPieceDbo artPiece;

    public static OrderItemDbo of(OrderItemDto dto){
        return OrderItemDbo.builder()
                .id(dto.getId())
                .order(OrderDbo.of(dto.getOrderDto()))
                .artPiece(ArtPieceDbo.of(dto.getArtPieceDto()))
                .amount(dto.getAmount())
                .build();
    }
}
