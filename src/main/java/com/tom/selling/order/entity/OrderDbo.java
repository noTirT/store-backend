package com.tom.selling.order.entity;

import com.tom.selling.orderitem.entity.OrderItemDbo;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ARTORDER")
@Builder
public class OrderDbo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "orders_id_seq")
    @Column(name="ORDER_ID")
    private Long id;

    @Column(name="TOTAL")
    private Float total;

    @Column(name="CUSTOMER_EMAIL")
    private String customeremail;

    @Column(name="ORDERED_AT_TIMESTAMP")
    private Long orderedattimestamp;

    @Column(name="FULLFILLED")
    private boolean fullfilled;

    @OneToMany(mappedBy = "ARTORDER", cascade = CascadeType.ALL)
    private Set<OrderItemDbo> orderItems;

    //todo order can contain multiple items; update readme file

    public static OrderDbo of(OrderDto dto){
        return OrderDbo.builder()
                .id(dto.getId())
                .total(dto.getTotal())
                .customeremail(dto.getCustomerEmail())
                .orderedattimestamp(dto.getDateOrderedAt())
                .fullfilled(dto.isFullFilled())
                .orderItems(dto.getOrderItems().stream().map(OrderItemDbo::of).collect(Collectors.toSet()))
                .build();
    }
}
