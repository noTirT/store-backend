package com.tom.selling.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orderItems")
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "orderitems_id_seq")
    private Long id;

    @Column
    private Long itemId;

    @Column
    private Long orderId;

    @Column
    private int amount;

    @Column
    private float totalPrice;
}
