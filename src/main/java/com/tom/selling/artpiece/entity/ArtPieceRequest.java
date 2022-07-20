package com.tom.selling.artpiece.entity;


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
    private Long categoryID;
    private List<String> imageURLs;
    private String description;
}
