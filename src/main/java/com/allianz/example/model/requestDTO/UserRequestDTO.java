package com.allianz.example.model.requestDTO;

import com.allianz.example.database.entity.MovieEntity;
import com.allianz.example.model.MovieDTO;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequestDTO {

    private String email;
    private String name;
    private Set<MovieDTO> movies;
}
