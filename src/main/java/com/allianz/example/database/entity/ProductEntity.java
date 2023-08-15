package com.allianz.example.database.entity;

import com.allianz.example.model.enums.ColorEnum;
import com.allianz.example.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
public class ProductEntity extends BaseEntity {


    @Column
    private String name;

    @Column
    private String code;

    @Enumerated(EnumType.STRING)
    private ColorEnum color;

    @Column
    private BigDecimal sellPrice;

    @Column
    private BigDecimal buyPrice;

    @Column
    private Integer quantity;

    @ManyToMany()
    @JoinTable(name = "category_product",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private Set<CategoryEntity> categoryList;


    @ManyToOne(fetch = FetchType.EAGER)
    private TaxEntity tax;


}
