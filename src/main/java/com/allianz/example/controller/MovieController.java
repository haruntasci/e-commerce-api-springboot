package com.allianz.example.controller;

import com.allianz.example.model.MovieDTO;
import com.allianz.example.model.requestDTO.MovieRequestDTO;
import com.allianz.example.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieRequestDTO movieRequestDTO){
        return new ResponseEntity<>(movieService.createMovie(movieRequestDTO), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll(){
        return new ResponseEntity<>(movieService.getAllMovies(),HttpStatus.OK);
    }

}
