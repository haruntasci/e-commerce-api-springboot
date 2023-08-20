package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table
public class BillEntity extends BaseEntity {

    @Column(unique = true)
    private String billNo;

    @Column
    private LocalDateTime billDate = LocalDateTime.now();

//    @Column
//    private BigDecimal taxRate;

    @Column
    private BigDecimal taxAmount;

    @Column
    private BigDecimal totalAmount;

    @Column
    private BigDecimal taxFreeAmount;

    @OneToOne
    private OrderEntity order;



}
