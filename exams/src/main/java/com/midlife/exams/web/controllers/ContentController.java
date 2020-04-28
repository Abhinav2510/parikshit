package com.midlife.exams.web.controllers;

import com.midlife.exams.jpa.entities.Content;
import com.midlife.exams.jpa.entities.Question;
import com.midlife.exams.jpa.repo.QuestionsRepo;
import com.midlife.exams.jpa.repo.ContentRepo;
import com.midlife.exams.web.models.ContentDTO;
import com.midlife.exams.web.models.QuestionDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contents/")
@CrossOrigin
public class ContentController {
    @Autowired
    ContentRepo contentRepo;
    @Autowired
    QuestionsRepo questionsRepo;

    @Autowired
    ModelMapper mapper;

    @GetMapping("/groups/")
    public List<ContentDTO> getAllGroups() {
        Type type = new TypeToken<List<ContentDTO>>() {
        }.getType();
        return mapper.map(contentRepo.getAllByType(Content.TestContentType.GROUP), type);
    }


    @GetMapping
    public List<ContentDTO> getAll() {
        Type type = new TypeToken<List<ContentDTO>>() {
        }.getType();
        return mapper.map(contentRepo.findAll(), type);
    }

    @GetMapping
    @RequestMapping("/{contentId}")
    public ResponseEntity<ContentDTO> get(@PathVariable("contentId") long contentId) {
        Content content = contentRepo.findById(contentId).orElse(null);
        if (content == null) {
            return ResponseEntity.notFound().build();
        }
        Collections.sort(content.getChildContents(), Comparator.comparingInt(Content::getPositionInParentContent));
        return ResponseEntity.ok(mapper.map(content, ContentDTO.class));
    }

    @GetMapping
    @RequestMapping("/{contentId}/questions")
    public ResponseEntity<QuestionDTO> getQuestionsByContent(@PathVariable("contentId") long contentId) {
        List<Question> questionsList = questionsRepo.findByContentContentId(contentId);
        Type type = new TypeToken<List<QuestionDTO>>() {
        }.getType();
        return ResponseEntity.ok(mapper.map(questionsList, type));
    }

    @GetMapping(path = "/search")
    public List<ContentDTO> searchContent(@PathParam("query") Optional<String> query) {
        if (!query.isPresent()) {
            return null;
        }
        Type type=new TypeToken<List<ContentDTO>>(){}.getType();
        return mapper.map(contentRepo.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query.get(),query.get()),type);
    }

}
