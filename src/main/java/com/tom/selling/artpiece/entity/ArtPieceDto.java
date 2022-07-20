package com.tom.selling.artpiece.entity;

import com.tom.selling.category.entity.CategoryDbo;
import com.tom.selling.category.entity.CategoryDto;
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

    private String description;

    private CategoryDto categoryDto;

    public static ArtPieceDto of(ArtPieceDbo item) {
        return ArtPieceDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .description(item.getDescription())
                .categoryDto(CategoryDto.of(item.getCategory()))
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
