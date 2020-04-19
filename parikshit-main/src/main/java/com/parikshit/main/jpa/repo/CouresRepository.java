package com.parikshit.main.jpa.repo;

import com.parikshit.main.jpa.entities.Course;
import com.parikshit.main.jpa.entities.CourseGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouresRepository extends JpaRepository<Course,Long> {
    List<Course> findByCourseGroup(CourseGroup courseGroup);
}
