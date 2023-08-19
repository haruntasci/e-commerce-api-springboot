package com.allianz.example.model.requestDTO;

import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class OrderRequestDTO extends BaseDTO {

    private UUID customerUUID;
    private List<UUID> orderItemUUIDList;

}
