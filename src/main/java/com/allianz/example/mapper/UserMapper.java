package com.allianz.example.mapper;

import com.allianz.example.database.entity.UserEntity;
import com.allianz.example.model.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class UserMapper {

    private final MovieMapper movieMapper;

    public UserMapper(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public UserEntity dtoToEntity(UserDTO userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        if(userDto.getMovies()!=null){
            userEntity.setMovies(new HashSet<>(movieMapper.dtoListToEntityList(new ArrayList<>(userDto.getMovies()))));
        }
        return userEntity;
    }
    public UserDTO entityToDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        if(userEntity.getMovies()!=null){
            userDTO.setMovies(new HashSet<>(movieMapper.entityListToDTOList(new ArrayList<>(userEntity.getMovies()))));
        }
        return userDTO;
    }

    public List<UserEntity> dtoListToEntityList(List<UserDTO> userDTOS){
        List<UserEntity> userEntities = new ArrayList<>();
        for(UserDTO userDTO : userDTOS){
            userEntities.add(dtoToEntity(userDTO));
        }
        return userEntities;
    }

}
