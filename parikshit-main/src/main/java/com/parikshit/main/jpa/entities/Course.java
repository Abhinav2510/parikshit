package com.parikshit.main.jpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue
    long courseId;

    String name;
    String description;
    String logoUrl;

    @ManyToOne
    @JoinColumn(name = "courseGroupId")
    @JsonBackReference
    CourseGroup courseGroup;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    @JsonManagedReference
    List<CoursePart> courseParts;


    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseGroup getCourseGroup() {
        return courseGroup;
    }

    public void setCourseGroup(CourseGroup courseGroup) {
        this.courseGroup = courseGroup;
    }

    public List<CoursePart> getCourseParts() {
        return courseParts;
    }

    public void setCourseParts(List<CoursePart> courseParts) {
        this.courseParts = courseParts;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }


}
