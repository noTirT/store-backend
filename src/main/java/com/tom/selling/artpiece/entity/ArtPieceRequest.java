package com.tom.selling.artpiece.entity;


import com.tom.selling.category.entity.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtPieceRequest {
    private String name;
    private Float price;
    private CategoryDto categoryDto;
    private List<String> imageURLs;
    private String description;
}
