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
@Table(name = "artpieces")
@Builder
public class ArtPieceDbo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "artpieces_id_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private Float prize;

    @Column
    private String imagelink;

    @Column
    private String description;

    @Column
    private Long categoryid;

    public ArtPieceDbo(String name) {
        this.name = name;
    }

    public static ArtPieceDbo of(ArtPieceLinkList rawItem){
        return ArtPieceDbo.builder()
                .name(rawItem.getName())
                .prize(rawItem.getPrize())
                .description(rawItem.getDescription())
                .categoryid(rawItem.getCategory().getId())
                .imagelink(String.join(" ", rawItem.getImagelinks()))
                .build();
    }
}
