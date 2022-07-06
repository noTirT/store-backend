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
@Table(name = "orders")
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "artpieces_id_seq")
    private Long id;

    @Column
    private Long ordereditemid;

    @Column
    private Float total;

    @Column
    private String customeremail;

    @Column
    private Long orderedattimestamp;

    @Column
    private boolean fullfilled;

    //todo order can contain multiple items; update readme file
}
