package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class PersonDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;
    private String mail;
    private List<AddressDTO> addressList;

}


