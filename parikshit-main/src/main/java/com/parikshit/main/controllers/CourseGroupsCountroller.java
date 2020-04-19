package com.parikshit.main.controllers;

import com.parikshit.main.jpa.repo.CourseGroupsRepo;
import com.parikshit.main.rest.dto.CourseGroupDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:8081")
public class CourseGroupsCountroller {

    @Autowired
    CourseGroupsRepo repo;
    @Autowired
    ModelMapper modelMapper;


    @RequestMapping(path = "/groups/")
    List<CourseGroupDTO> getAll() {
        Type type= new TypeToken<List<CourseGroupDTO>>(){}.getType();
        return modelMapper.map(repo.findAll(),type);
    }

    @RequestMapping(path = "/groups/{groupId}")
    CourseGroupDTO get(@PathVariable  long groupId){
        return  modelMapper.map(repo.getOne(groupId),CourseGroupDTO.class);
    }
}
