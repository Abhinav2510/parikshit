package com.midlife.exams.jpa.repo;

import com.midlife.exams.jpa.entities.Content;
import com.midlife.exams.jpa.entities.Content.TestContentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestContentRepo extends JpaRepository<Content,Long> {
    List<Content> getAllByType(TestContentType type);
}
