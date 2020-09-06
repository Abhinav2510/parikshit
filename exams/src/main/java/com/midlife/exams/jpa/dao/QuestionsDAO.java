package com.midlife.exams.jpa.dao;

import com.midlife.exams.jpa.entities.Question;
import com.midlife.exams.jpa.repo.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.List;

@Component
public class QuestionsDAO {
    @Autowired
    private QuestionsRepo questionsRepo;

    @Nonnull
    public List<Question> getAllQuestionsByContentId(long contentId) {
        return questionsRepo.findByContentContentId(contentId);
    }
}
