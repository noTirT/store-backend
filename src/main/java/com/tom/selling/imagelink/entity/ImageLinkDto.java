package com.tom.selling.imagelink.entity;

import com.tom.selling.artpiece.entity.ArtPieceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageLinkDto {
    private Long id;
    private String link;
    private ArtPieceDto artPieceDto;

    public static ImageLinkDto of(ImageLinkDbo imageLinkDbo) {
        return ImageLinkDto.builder()
                .id(imageLinkDbo.getId())
                .link(imageLinkDbo.getLink())
                .artPieceDto(ArtPieceDto.of(imageLinkDbo.getArtPieceDbo()))
                .build();
    }
}
