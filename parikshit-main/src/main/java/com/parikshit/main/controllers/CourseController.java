package com.parikshit.main.controllers;

import com.parikshit.main.jpa.repo.CouresRepository;
import com.parikshit.main.jpa.repo.CourseGroupsRepo;
import com.parikshit.main.rest.dto.CourseDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("/api/groups/")
public class CourseController {

    @Autowired
    CouresRepository couresRepo;
    @Autowired
    CourseGroupsRepo groupsRepo;
    @Autowired
    ModelMapper mapper;

    @GetMapping("/{groupId}/course/")
    public List<CourseDTO> getAll(@PathVariable  long groupId){
        Type type=new TypeToken<List<CourseDTO>>(){}.getType();
        return mapper.map(couresRepo.findByCourseGroup(groupsRepo.getOne(groupId)),type);
    }
}
