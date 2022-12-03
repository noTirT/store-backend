package com.tom.selling.category.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATEGORY")
@Builder
public class CategoryDbo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "category_id_seq")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    public CategoryDbo(String categoryName){
        this.categoryName = categoryName;
    }

    public static CategoryDbo of (CategoryDto dto){
        return CategoryDbo.builder()
                .id(dto.getId())
                .categoryName(dto.getCategoryName())
                .build();

    }
    public static CategoryDbo of (CategoryRequest request){
        return CategoryDbo.builder()
                .categoryName(request.getCategoryName())
                .build();
    }
}
