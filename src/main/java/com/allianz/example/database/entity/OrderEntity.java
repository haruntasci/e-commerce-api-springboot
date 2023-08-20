package com.allianz.example.database.entity;

import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table
public class OrderEntity extends BaseEntity {

    @ManyToOne
    private CustomerEntity customer;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus = OrderStatusEnum.WAITING;

    @OneToMany
    private List<OrderItemEntity> orderItemList;

    @Column
    private BigDecimal totalAmount;

}