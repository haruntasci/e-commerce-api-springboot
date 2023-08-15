package com.allianz.example.database.repository;

import com.allianz.example.database.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Long> {
}
