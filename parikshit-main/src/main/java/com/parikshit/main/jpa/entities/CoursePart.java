package com.parikshit.main.jpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courseParts")
public class CoursePart {
    @Id
    @GeneratedValue
    long  partId;
    String name;
    String description;

    @ManyToOne
    @JoinColumn(name = "courseid")
    @JsonBackReference
    Course course;

    @ManyToMany(mappedBy = "coursePartList")
    List<Subject> subjectsList;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(List<Subject> subjectsList) {
        this.subjectsList = subjectsList;
    }
}
