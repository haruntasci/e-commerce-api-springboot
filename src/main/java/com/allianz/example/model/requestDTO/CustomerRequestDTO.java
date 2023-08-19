package com.allianz.example.model.requestDTO;


import com.allianz.example.model.PersonDTO;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CustomerRequestDTO extends BaseDTO {
    private UUID personUUID;
    private Boolean isCorporate;
    private String companyName;
    private String taxNumber;
    private String taxOffice;
    //private List<OrderRequestDTO> orderList;

}
