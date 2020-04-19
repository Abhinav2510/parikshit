package com.parikshit.main.rest.dto;

import java.util.List;

public class CourseDTO {

    long courseId;
    String name;
    String description;
    String logoUrl;
    String imageUrl;
    String iconName;
    long courseGroupId;
    String courseGroupName;
    List<CoursePartsDTO> courseParts;

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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

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

    public List<CoursePartsDTO> getCourseParts() {
        return courseParts;
    }

    public void setCourseParts(List<CoursePartsDTO> courseParts) {
        this.courseParts = courseParts;
    }
}
class CoursePartsDTO{
    long  partId;
    String name;
    String description;
    String logoUrl;
    String imageUrl;

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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}