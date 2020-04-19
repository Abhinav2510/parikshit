package com.parikshit.main.rest.dto;

import java.util.List;

public class SubjectDTO {
    long subjectId;
    String name;
    String description;

    List<CoursePartDTO> coursePartList;

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
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

    public List<CoursePartDTO> getCoursePartList() {
        return coursePartList;
    }

    public void setCoursePartList(List<CoursePartDTO> coursePartList) {
        this.coursePartList = coursePartList;
    }
}
