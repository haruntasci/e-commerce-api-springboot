package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table
public class CustomerEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private PersonEntity person;

    @Column
    private Boolean isCorporate;

    @Column
    private String companyName;

    @Column
    private String taxNumber;

    @Column
    private String taxOffice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<OrderEntity> orderList;


}
