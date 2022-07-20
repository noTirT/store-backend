package com.tom.selling.category.entity;

import com.tom.selling.artpiece.entity.ArtPieceDbo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATEGORY")
@Builder
public class CategoryDbo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String categoryname;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ArtPieceDbo> artPieceDbos;


    public CategoryDbo(String categoryname) {
        this.categoryname = categoryname;
    }

    public static CategoryDbo of (CategoryDto dto){
        return CategoryDbo.builder()
                .categoryname(dto.getCategoryName())
                .build();
    }
}
