package com.parikshit.main.jpa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CourseGroups")
public class CourseGroup {

    @Id
    @GeneratedValue
    long courseGroupId;

    String courseGroupName;
    String description;
    String region;

    @OneToMany(mappedBy = "courseGroup")
    @JsonManagedReference
    List<Course> courseList;

    public long getCourseGroupId() {
        return courseGroupId;
    }

    public void setCourseGroupId(long courseGroupId) {
        this.courseGroupId = courseGroupId;
    }

    public String getCourseGroupName() {
        return courseGroupName;
    }

    public void setCourseGroupName(String courseGroupName) {
        this.courseGroupName = courseGroupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
