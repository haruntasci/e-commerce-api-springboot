package com.allianz.example.model.requestDTO;

import com.allianz.example.model.SortDTO;
import lombok.Data;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
}
