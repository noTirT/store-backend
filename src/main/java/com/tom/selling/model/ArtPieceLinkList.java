package com.tom.selling.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtPieceLinkList {

    private Long id;

    private String name;

    private Float price;

    private String[] imagelinks;

    private String description;

    private Category category;

    public static ArtPieceLinkList of(ArtPieceDbo item, Category category) {
        return ArtPieceLinkList.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .description(item.getDescription())
                .category(category == null ? new Category(-1L, "No category provided") : category)
                .imagelinks(item.getImagelink().split(" "))
                .build();
    }
}
