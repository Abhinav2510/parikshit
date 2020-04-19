package com.midlife.exams.jpa.repo;

import com.midlife.exams.jpa.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepo  extends JpaRepository<Tag,Long> {
}
