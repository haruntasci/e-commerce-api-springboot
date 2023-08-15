package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillDTO extends BaseDTO {
    private String billNo;
    private LocalDateTime billDate;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;
    private BigDecimal totalSellNetPrice;
    private BigDecimal totalSellPrice;
    private OrderDTO order;
}
