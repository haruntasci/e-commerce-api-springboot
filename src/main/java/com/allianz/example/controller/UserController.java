package com.allianz.example.controller;

import com.allianz.example.model.UserDTO;
import com.allianz.example.model.requestDTO.UserRequestDTO;
import com.allianz.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<>(userService.createUser(userRequestDTO), HttpStatus.OK);
    }
}
