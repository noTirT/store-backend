package com.tom.selling.imagelink.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageLinkResponse {
    private Long id;
    private String link;

    public static ImageLinkResponse of(ImageLinkDto dto){
        return ImageLinkResponse.builder()
                .id(dto.getId())
                .link(dto.getLink())
                .build();
    }
}
