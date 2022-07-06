package com.tom.selling.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtPieceLinkList {

    private Long id;

    private String name;

    private Float prize;

    private String[] imagelink;

    private String description;

    private String category;

    public static ArtPieceLinkList of(ArtPiece item){
        return ArtPieceLinkList.builder()
                .id(item.getId())
                .name(item.getName())
                .prize(item.getPrize())
                .description(item.getDescription())
                .category(item.getCategory())
                .imagelink(item.getImagelink().split(" "))
                .build();
    }
}
