package com.tom.selling.artpiece.entity;

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

    public static ImageLinkDto of(ImageLinkDbo imageLinkDbo) {
        return ImageLinkDto.builder()
                .id(imageLinkDbo.getId())
                .link(imageLinkDbo.getLink())
                .build();
    }
}
