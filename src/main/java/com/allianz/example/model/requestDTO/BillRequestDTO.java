package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BillRequestDTO extends BaseDTO {
    private String billNo;
//    private BigDecimal taxRate;
//    private BigDecimal taxAmount;
//    private BigDecimal taxFreeAmount;
//    private BigDecimal totalAmount;
    private UUID orderUUID;
}
