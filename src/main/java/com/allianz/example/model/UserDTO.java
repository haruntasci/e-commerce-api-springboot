package com.allianz.example.model;

import com.allianz.example.database.entity.MovieEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {


    private String email;
    private String name;
    private Set<MovieDTO> movies;
}
