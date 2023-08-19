package com.allianz.example.model.requestDTO;

import com.allianz.example.model.enums.OrderStatusEnum;
import lombok.Data;

@Data
public class OrderStatusRequestDTO {
    private OrderStatusEnum orderStatus;
}
