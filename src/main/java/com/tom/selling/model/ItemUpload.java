package com.tom.selling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemUpload {
    private String name;

    private Float prize;

    private String[] imagelinks;

    private String description;

    private String category;
}
