package com.allianz.example.service;

import com.allianz.example.database.entity.MovieEntity;
import com.allianz.example.database.repository.MovieRepository;
import com.allianz.example.mapper.MovieMapper;
import com.allianz.example.model.MovieDTO;
import com.allianz.example.model.requestDTO.MovieRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public MovieDTO createMovie(MovieRequestDTO movieRequestDTO){

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(movieRequestDTO.getName());
        movieEntity.setDescription(movieRequestDTO.getDescription());
        movieEntity.setReleaseDate(movieRequestDTO.getReleaseDate());
        movieRepository.save(movieEntity);
        return movieMapper.entityToDTO(movieEntity);

    }
    public List<MovieDTO> getAllMovies(){
        return movieMapper.entityListToDTOList(movieRepository.findAll());
    }


}
