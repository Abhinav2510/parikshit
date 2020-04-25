package com.midlife.exams.jpa.repo;

import com.midlife.exams.jpa.entities.Content;
import com.midlife.exams.jpa.entities.Content.TestContentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepo extends JpaRepository<Content, Long> {
    List<Content> getAllByType(TestContentType type);

    List<Content> getAllByTypeAndParentContentContentId(TestContentType type, long parentContentId);

    List<Content> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name,String description);
}
