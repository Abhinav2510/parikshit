package com.parikshit.main.rest.dto;

import java.util.List;

public class CoursePartDTO {
    long  partId;
    String name;
    String description;

    CourseDTO course;

    List<SubjectDTO> subjectsList;

    public long getPartId() {
        return partId;
    }

    public void setPartId(long partId) {
        this.partId = partId;
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

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public List<SubjectDTO> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(List<SubjectDTO> subjectsList) {
        this.subjectsList = subjectsList;
    }
}
