package com.midlife.exams.jpa.repo;

import com.midlife.exams.jpa.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepo extends JpaRepository<Question,Long> {
    List<Question> findByPartTestContentPartId(long partId);
}
