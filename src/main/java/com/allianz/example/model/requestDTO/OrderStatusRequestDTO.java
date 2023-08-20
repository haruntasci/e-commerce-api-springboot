package com.allianz.example.model.requestDTO;

import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class OrderStatusRequestDTO {
    private OrderStatusEnum orderStatus;
}
