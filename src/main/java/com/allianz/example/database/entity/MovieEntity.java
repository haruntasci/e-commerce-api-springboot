package com.allianz.example.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "movies")
@Entity
@Data
public class MovieEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Lob
    private String description;

    @Column(nullable = false)
    private Integer releaseDate;

    @ManyToMany(mappedBy = "movies")
    private Set<UserEntity> users;
}
