package com.tom.selling.category.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private Long id;
    private String categoryName;

    public static CategoryDto of(CategoryDbo categoryDbo) {
        return CategoryDto.builder()
                .id(categoryDbo.getId())
                .categoryName(categoryDbo.getCategoryName())
                .build();
    }
    public static CategoryDto of(CategoryDto categoryDto) {
        return CategoryDto.builder()
                .id(categoryDto.getId())
                .categoryName(categoryDto.getCategoryName())
                .build();
    }
}
