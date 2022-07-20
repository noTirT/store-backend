package com.tom.selling.artpiece.entity;

import com.tom.selling.category.entity.CategoryDbo;
import com.tom.selling.imagelink.entity.ImageLinkDbo;
import com.tom.selling.orderitem.entity.OrderItemDbo;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ARTPIECE")
@Builder
public class ArtPieceDbo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "artpiece_id_seq")
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID", nullable = false, referencedColumnName = "ID")
    private CategoryDbo category;

    public static ArtPieceDbo of(ArtPieceDto dto){
        return ArtPieceDbo.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .category(CategoryDbo.of(dto.getCategoryDto()))
                .build();
    }
}
