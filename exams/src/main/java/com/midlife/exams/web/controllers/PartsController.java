package com.midlife.exams.web.controllers;

import com.midlife.exams.jpa.entities.Question;
import com.midlife.exams.jpa.entities.TestContentPart;
import com.midlife.exams.jpa.repo.QuestionsRepo;
import com.midlife.exams.jpa.repo.TestContentPartRepo;
import com.midlife.exams.web.models.TestPartDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping(path = "/contents/{contentId}/parts/")
public class PartsController {
    @Autowired
    QuestionsRepo qRepo;
    @Autowired
    TestContentPartRepo partRepo;

    @Autowired
    ModelMapper mapper;

    @GetMapping
    List<TestPartDTO> getAll(@PathVariable("contentId") long contentId){
        List<TestContentPart> contentPartsList= partRepo.findByContentContentId(contentId);
        Type type= new TypeToken<List<TestPartDTO>>(){}.getType();
        return mapper.map(contentPartsList,type);
    }

}
