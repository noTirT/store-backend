package com.tom.selling.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemReturn {

    private Long id;

    private String name;

    private Float prize;

    private String[] imagelinks;

    private String description;

    private String category;

    public static ItemReturn of(ArtPiece item){
        return ItemReturn.builder()
                .id(item.getId())
                .name(item.getName())
                .prize(item.getPrize())
                .imagelinks(item.getImagelink().split("\\|\\|\\|"))
                .description(item.getDescription())
                .category(item.getCategory())
                .build();
    }
}
