package com.midlife.exams.jpa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Content {


    public enum TestContentType{
        GROUP,
        EXAM,
        MODULE,
        PART,
        LEARNINGMODULE,
        PRACTICEMODULE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long contentId;

    String name;
    String description;

    @Enumerated(EnumType.STRING)
    TestContentType type;

    @ManyToOne
    Content parentContent;

    @OneToMany(mappedBy = "content")
    List<TestContentPart> testPartsList;

    @OneToMany(mappedBy = "parentContent")
    List<Content> childContents;

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long testId) {
        this.contentId = testId;
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

    public List<TestContentPart> getTestPartsList() {
        return testPartsList;
    }

    public void setTestPartsList(List<TestContentPart> testPartsList) {
        this.testPartsList = testPartsList;
    }

    public TestContentType getType() {
        return type;
    }

    public void setType(TestContentType type) {
        this.type = type;
    }


    public List<Content> getChildContents() {
        return childContents;
    }

    public void setChildContents(List<Content> childContents) {
        this.childContents = childContents;
    }

    public Content getParentContent() {
        return parentContent;
    }

    public void setParentContent(Content parentContent) {
        this.parentContent = parentContent;
    }
}

