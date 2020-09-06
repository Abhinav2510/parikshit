package com.midlife.exams.web.controllers;

import com.midlife.exams.jpa.dao.ContentDao;
import com.midlife.exams.jpa.dao.QuestionsDAO;
import com.midlife.exams.jpa.entities.Content;
import com.midlife.exams.jpa.entities.Question;
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
    private ContentDao contentDao;

    @Autowired
    private QuestionsDAO questionsDAO;

    @Autowired
    private ModelMapper mapper;

    private static final Type contentDTOListType = new TypeToken<List<ContentDTO>>() {
    }.getType();

    public ContentController() {
    }

    @GetMapping("/groups/")
    public List<ContentDTO> getAllGroups() {
        return mapper.map(contentDao.getAllGroups(), contentDTOListType);
    }


    @GetMapping
    public List<ContentDTO> getAll() {
        return mapper.map(contentDao.getAll(), contentDTOListType);
    }

    @GetMapping
    @RequestMapping("/{contentId}")
    public ResponseEntity<ContentDTO> get(@PathVariable("contentId") long contentId) {
        Content content = contentDao.getbyId(contentId);
        if (content == null) {
            return ResponseEntity.notFound().build();
        }
        Collections.sort(content.getChildContents(), Comparator.comparingInt(Content::getPositionInParentContent));
        return ResponseEntity.ok(mapper.map(content, ContentDTO.class));
    }

    @GetMapping
    @RequestMapping("/{contentId}/questions")
    public ResponseEntity<QuestionDTO> getQuestionsByContent(@PathVariable("contentId") long contentId) {
        List<Question> questionsList = questionsDAO.getAllQuestionsByContentId(contentId);
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
        return mapper.map(contentDao.searchContentByNameOrDescription(query.get()),type);
    }

}
