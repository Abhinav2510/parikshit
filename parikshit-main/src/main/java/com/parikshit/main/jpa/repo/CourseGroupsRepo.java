package com.parikshit.main.jpa.repo;

import com.parikshit.main.jpa.entities.CourseGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseGroupsRepo extends JpaRepository<CourseGroup,Long> {
}
