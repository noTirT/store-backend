package com.tom.selling.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Array;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "artpieces")
@Builder
@Slf4j
public class ArtPiece {

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
    private String category;

    public ArtPiece(String name) {
        this.name = name;
    }

    public static ArtPiece of(ArtPieceLinkList rawItem){
        log.info(rawItem.toString());
        return ArtPiece.builder()
                .name(rawItem.getName())
                .prize(rawItem.getPrize())
                .description(rawItem.getDescription())
                .category(rawItem.getCategory())
                .imagelink(String.join(" ", rawItem.getImagelinks()))
                .build();
    }
}
