package com.allianz.example.mapper;

import com.allianz.example.database.entity.MovieEntity;
import com.allianz.example.model.MovieDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {
    public MovieDTO entityToDTO(MovieEntity movieEntity) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieEntity.getId());
        movieDTO.setName(movieEntity.getName());
        movieDTO.setDescription(movieDTO.getDescription());
        movieDTO.setReleaseDate(movieEntity.getReleaseDate());
        return movieDTO;
    }

    public List<MovieDTO> entityListToDTOList(List<MovieEntity> movieEntities) {
        List<MovieDTO> movieDTOS = new ArrayList<>();
        for (MovieEntity entity : movieEntities) {
            movieDTOS.add(entityToDTO(entity));
        }
        return movieDTOS;
    }

    public List<MovieEntity> dtoListToEntityList(List<MovieDTO> movieDTOS) {
        List<MovieEntity> movieEntities = new ArrayList<>();
        for (MovieDTO movieDTO : movieDTOS) {
            movieEntities.add(dtoToEntity(movieDTO));
        }
        return movieEntities;
    }

    public MovieEntity dtoToEntity(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(movieDTO.getName());
        movieEntity.setDescription(movieDTO.getDescription());
        movieEntity.setId(movieDTO.getId());
        movieEntity.setReleaseDate(movieDTO.getReleaseDate());
        return movieEntity;
    }
}
