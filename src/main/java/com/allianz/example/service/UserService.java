package com.allianz.example.service;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.MovieEntity;
import com.allianz.example.database.entity.UserEntity;
import com.allianz.example.database.repository.MovieRepository;
import com.allianz.example.database.repository.UserRepository;
import com.allianz.example.mapper.MovieMapper;
import com.allianz.example.mapper.UserMapper;
import com.allianz.example.model.MovieDTO;
import com.allianz.example.model.UserDTO;
import com.allianz.example.model.requestDTO.UserRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final MovieMapper movieMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MovieRepository movieRepository;
    public UserService(MovieMapper movieMapper, UserRepository userRepository, UserMapper userMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.movieRepository = movieRepository;
    }

    public UserDTO createUser(UserRequestDTO userRequestDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequestDTO.getName());
        userEntity.setEmail(userRequestDTO.getEmail());

        Set<MovieEntity> movieEntities = new HashSet<>(movieMapper
                .dtoListToEntityList(new ArrayList<>(userRequestDTO.getMovies())));

        Set<MovieEntity> associatedMovies = new HashSet<>();

        for(MovieEntity movieEntity : movieEntities){
            MovieEntity movieEntity1 = movieRepository.findById(movieEntity.getId()).get();
            associatedMovies.add(movieEntity1);
        }
        userEntity.setMovies(associatedMovies);

        userRepository.save(userEntity);
        return userMapper.entityToDTO(userEntity);

    }


}
