package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemRequestDTO extends BaseDTO {
    private ProductRequestDTO product;
    private Integer quantity;
    private BigDecimal orderPrice;
}
