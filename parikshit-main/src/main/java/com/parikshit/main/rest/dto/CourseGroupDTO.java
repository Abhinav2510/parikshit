package com.parikshit.main.rest.dto;

import java.util.List;

public class CourseGroupDTO {

    long courseGroupId;
    String courseGroupName;
    String description;
    String region;
    List<CourseInnerDTO> courseList;

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

    public List<CourseInnerDTO> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseInnerDTO> courseList) {
        this.courseList = courseList;
    }


}
class CourseInnerDTO{
    int courseID;
    String courseName;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}