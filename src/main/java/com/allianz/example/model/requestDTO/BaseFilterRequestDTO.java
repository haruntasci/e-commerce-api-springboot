package com.allianz.example.model.requestDTO;

import com.allianz.example.model.SortDTO;
import com.allianz.example.util.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    List<SearchCriteria> searchCriteriaList;
}
