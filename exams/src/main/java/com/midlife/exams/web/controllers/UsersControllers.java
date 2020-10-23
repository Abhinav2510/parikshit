package com.midlife.exams.web.controllers;

import com.midlife.exams.jpa.dao.UsersDAO;
import com.midlife.exams.jpa.entities.security.UserEntity;
import com.midlife.exams.web.models.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/public")
public class UsersControllers {

    @Autowired
    UsersDAO usersDAO;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @RequestMapping("/signup")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO){

        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        usersDAO.saveUser(userEntity);
        return new ResponseEntity(HttpStatus.CREATED);
     }

}
