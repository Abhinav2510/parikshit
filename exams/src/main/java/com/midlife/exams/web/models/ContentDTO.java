package com.midlife.exams.web.models;

import java.util.List;

public class ContentDTO {
    long contentId;

    long parentContentContentId;

    String name;
    String description;
    String type;

    List<ChildContentDTO> childContents;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ChildContentDTO> getChildContents() {
        return childContents;
    }

    public void setChildContents(List<ChildContentDTO> childContents) {
        this.childContents = childContents;
    }

    public long getParentContentContentId() {
        return parentContentContentId;
    }

    public void setParentContentContentId(long parentContentContentId) {
        this.parentContentContentId = parentContentContentId;
    }


}
class ChildContentDTO{
    long contentId;
    long parentContentContentId;
    String name;
    String description;
    String type;

    public ChildContentDTO() {
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public long getParentContentContentId() {
        return parentContentContentId;
    }

    public void setParentContentContentId(long parentContentContentId) {
        this.parentContentContentId = parentContentContentId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
