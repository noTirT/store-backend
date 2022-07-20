package com.tom.selling.artpiece.entity;

import com.tom.selling.category.entity.CategoryDbo;
import com.tom.selling.imagelink.entity.ImageLinkDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtPieceDto {

    private Long id;

    private String name;

    private Float price;

    private Set<ImageLinkDto> imageLinks;

    private String description;

    private CategoryDbo categoryDbo;

    public static ArtPieceDto of(ArtPieceDbo item) {
        return ArtPieceDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .description(item.getDescription())
                .categoryDbo(item.getCategory())
                .imageLinks(item.getImageLinks().stream().map(ImageLinkDto::of).collect(Collectors.toSet()))
                .build();
    }
}
