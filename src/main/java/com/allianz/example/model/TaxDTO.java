package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxDTO extends BaseDTO {
    private String name;
    private String code;
    private BigDecimal rate;
}
