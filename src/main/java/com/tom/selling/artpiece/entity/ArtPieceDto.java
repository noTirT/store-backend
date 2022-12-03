package com.tom.selling.artpiece.entity;

import com.tom.selling.category.entity.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtPieceDto {

    private Long id;

    private String name;

    private Float price;

    private String description;

    private CategoryDto categoryDto;

    private List<ImageLinkDto> imageLinks;

    public static ArtPieceDto of(ArtPieceDbo item) {
        return ArtPieceDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .description(item.getDescription())
                .categoryDto(CategoryDto.of(item.getCategory()))
                .imageLinks(item.getImageURLs().stream().map(ImageLinkDto::of).collect(Collectors.toList()))
                .build();
    }

    public static ArtPieceDto of(ArtPieceRequest request, CategoryDto category){
        return ArtPieceDto.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .categoryDto(category)
                .build();
    }
}
