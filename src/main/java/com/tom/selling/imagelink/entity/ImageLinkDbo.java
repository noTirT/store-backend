package com.tom.selling.imagelink.entity;

import com.tom.selling.artpiece.entity.ArtPieceDbo;
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
@Table(name = "image")
@Builder
public class ImageLinkDbo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "imagelink_id_seq")
    @Column(name = "IMAGE_ID")
    private Long id;

    @Column(name = "LINK")
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ARTPIECE_ID", referencedColumnName = "ARTPIECE_ID", nullable = false)
    private ArtPieceDbo artPieceDbo;

    public static ImageLinkDbo of(ImageLinkDto dto){
        return ImageLinkDbo.builder()
                .id(dto.getId())
                .link(dto.getLink())
                .artPieceDbo(ArtPieceDbo.of(dto.getArtPieceDto()))
                .build();
    }
}
