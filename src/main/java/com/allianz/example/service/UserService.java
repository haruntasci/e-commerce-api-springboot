package com.allianz.example.service;

import com.allianz.example.database.entity.RoleEntity;
import com.allianz.example.database.entity.UserEntity;
import com.allianz.example.database.repository.RoleEntityRepository;
import com.allianz.example.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserEntityRepository userRepository;
    @Autowired
    RoleEntityRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public void saveUserByRole(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roleList = new HashSet<>();
        for (RoleEntity entity : user.getRoles()) {
            Optional<RoleEntity> existedRole = roleRepository.findByName(entity.getName());
            if(existedRole.isPresent()){
                roleList.add(existedRole.get());
            }else{
                RoleEntity role = roleRepository.save(entity);
                roleList.add(role);
            }
        }
        user.setRoles(roleList);
        userRepository.save(user);
    }


}