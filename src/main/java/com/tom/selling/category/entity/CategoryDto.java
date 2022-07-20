package com.tom.selling.category.entity;

import com.tom.selling.artpiece.entity.ArtPieceDto;
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
public class CategoryDto {
    private Long id;
    private String categoryName;
    private Set<ArtPieceDto> artPieceDtos;

    public static CategoryDto of(CategoryDbo categoryDbo) {
        return CategoryDto.builder()
                .id(categoryDbo.getId())
                .categoryName(builder().categoryName)
                .artPieceDtos(categoryDbo.getArtPieceDbos().stream().map(ArtPieceDto::of).collect(Collectors.toSet()))
                .build();
    }
}
