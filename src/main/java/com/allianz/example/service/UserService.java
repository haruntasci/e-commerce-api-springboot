package com.allianz.example.service;

import com.allianz.example.database.entity.RoleEntity;
import com.allianz.example.database.entity.UserEntity;
import com.allianz.example.database.repository.RoleEntityRepository;
import com.allianz.example.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

        //dinamik
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        for (RoleEntity entity : user.getRoles()) {
            RoleEntity role = roleRepository.save(entity);
            roles.add(role);
        }
        user.setRoles(roles);
        userRepository.save(user);

//        //dinamik
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Set<RoleEntity> roles = new HashSet<>();
//        roles.add(roleRepository.findByName("user").get());
//        user.setRoles(roles);
//        userRepository.save(user);
    }


}