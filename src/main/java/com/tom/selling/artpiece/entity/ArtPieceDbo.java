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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "artpieces_id_seq")
    @Column(name="ARTPIECE_ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name = "PRICE")
    private Float price;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ImageLinkDbo> imageLinks;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID", nullable = false, referencedColumnName = "CATEGORY_ID")
    private CategoryDbo category;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OrderItemDbo> orders;

    public static ArtPieceDbo of(ArtPieceDto rawItem){
        return ArtPieceDbo.builder()
                .name(rawItem.getName())
                .price(rawItem.getPrice())
                .description(rawItem.getDescription())
                .category(rawItem.getCategoryDbo())
                .imageLinks(rawItem.getImageLinks().stream().map(ImageLinkDbo::of).collect(Collectors.toSet()))
                .build();
    }
}
