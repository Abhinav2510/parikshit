package com.midlife.exams.web.models;

import java.util.List;

public class ContentDTO {
    long contentId;

    long parentContentContentId;

    String name;
    String description;
    String type;

    List<ContentDTO> childContents;

    List<TestPartDTO> testPartsList;

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
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

    public List<TestPartDTO> getTestPartsList() {
        return testPartsList;
    }

    public void setTestPartsList(List<TestPartDTO> testPartsList) {
        this.testPartsList = testPartsList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ContentDTO> getChildContents() {
        return childContents;
    }

    public void setChildContents(List<ContentDTO> childContents) {
        this.childContents = childContents;
    }

    public long getParentContentContentId() {
        return parentContentContentId;
    }

    public void setParentContentContentId(long parentContentContentId) {
        this.parentContentContentId = parentContentContentId;
    }
}
