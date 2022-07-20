package com.tom.selling.artpiece.entity;


import com.tom.selling.category.entity.CategoryResponse;
import com.tom.selling.imagelink.entity.ImageLinkResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtPieceResponse {
    private Long id;
    private String name;
    private Float price;
    private List<ImageLinkResponse> imageLinks;
    private String description;
    private List<CategoryResponse> category;
}
