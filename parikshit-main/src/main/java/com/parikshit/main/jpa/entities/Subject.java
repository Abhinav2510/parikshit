package com.parikshit.main.jpa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue
    long subjectId;
    String name;
    String description;

    @ManyToMany
    @JoinTable(name = "coursepartsubjectmap",
            inverseJoinColumns = @JoinColumn(name="partId",referencedColumnName = "partId"),
            joinColumns = @JoinColumn(name = "subjectId",referencedColumnName = "subjectId")
    )
    List<CoursePart> coursePartList;

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

    public List<CoursePart> getCoursePartList() {
        return coursePartList;
    }

    public void setCoursePartList(List<CoursePart> coursePartList) {
        this.coursePartList = coursePartList;
    }
}
