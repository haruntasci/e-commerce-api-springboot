package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class SellerDTO extends BaseDTO {

    private String name;
    private String surname;
    private String tc;
    private String email;
    private String shopName;
    private String taxNumber;
    private String taxOffice;

}
