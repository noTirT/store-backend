package com.tom.selling.artpiece.entity;

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
@Table(name = "IMAGE")
@Builder
public class ImageLinkDbo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "image_id_seq")
    @Column(name = "ID")
    private Long id;

    @Column(name = "LINK")
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ARTPIECE_ID", referencedColumnName = "ID", nullable = false)
    private ArtPieceDbo artPieceDbo;

    public static ImageLinkDbo of(ImageLinkDto dto){
        return ImageLinkDbo.builder()
                .id(dto.getId())
                .link(dto.getLink())
                .build();
    }

    public ImageLinkDbo(String link, ArtPieceDbo artPieceDbo){
        this.link = link;
        this.artPieceDbo = artPieceDbo;
    }
}
