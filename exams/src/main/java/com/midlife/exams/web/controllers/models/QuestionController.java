package com.midlife.exams.web.controllers.models;

import com.midlife.exams.jpa.entities.Question;
import com.midlife.exams.jpa.repo.QuestionsRepo;
import com.midlife.exams.web.models.QuestionDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.lang.reflect.Type;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping(path = "/contents/{contentId}/parts/{partId}/questions/")
public class QuestionController {

    @Autowired
    QuestionsRepo questionsRepo;

    @Autowired
    ModelMapper mapper;

    @GetMapping
    public List<QuestionDTO> getAllQuestionsForPart(@PathVariable("partId")long partId){
        List<Question> questionsList=questionsRepo.findByPartTestContentPartId(partId);
        Type type=new TypeToken<List<QuestionDTO>>(){}.getType();
        return mapper.map(questionsList,type);
    }
}
