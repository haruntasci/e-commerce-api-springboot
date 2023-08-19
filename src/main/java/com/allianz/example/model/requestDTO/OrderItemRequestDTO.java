package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderItemRequestDTO extends BaseDTO {
    private UUID productUUID;
    private Integer quantity;
}
