package com.tom.selling.category.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {
    private Long id;
    private String categoryName;

    public static CategoryResponse of(CategoryDto dto){
        return CategoryResponse.builder()
                .id(dto.getId())
                .categoryName(dto.getCategoryName())
                .build();
    }
}
