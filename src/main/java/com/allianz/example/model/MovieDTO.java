package com.allianz.example.model;


import lombok.Data;


@Data
public class MovieDTO {

    private Long id;
    private String name;
    private String description;
    private Integer releaseDate;

}
