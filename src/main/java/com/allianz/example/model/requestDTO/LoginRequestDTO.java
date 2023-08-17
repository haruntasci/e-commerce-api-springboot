package com.allianz.example.model.requestDTO;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String email;
    private String password;
}