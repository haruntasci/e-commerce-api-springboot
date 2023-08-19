package com.allianz.example.model.requestDTO;

import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.enums.ColorEnum;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Data
public class ProductCategoryRequestDTO extends BaseDTO {
    private Set<UUID> categoryUUIDList;
}
