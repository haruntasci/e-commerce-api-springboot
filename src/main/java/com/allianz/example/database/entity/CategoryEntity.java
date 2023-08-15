package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
public class CategoryEntity extends BaseEntity {

    @Column
    private String name;


    @ManyToMany(mappedBy = "categoryList",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<ProductEntity> productList = new HashSet<>();


}
