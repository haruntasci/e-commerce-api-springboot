package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PersonRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;
    private String mail;


}
