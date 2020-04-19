package com.midlife.exams.jpa.repo;

import com.midlife.exams.jpa.entities.TestContentPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestContentPartRepo extends JpaRepository<TestContentPart,Long> {
    List<TestContentPart> findByContentContentId(long contentId);
}
