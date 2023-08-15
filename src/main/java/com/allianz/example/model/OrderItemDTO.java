package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO extends BaseDTO {
    private ProductDTO product;
    private Integer quantity;
    private BigDecimal sellPrice;
}
