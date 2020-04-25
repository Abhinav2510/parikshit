package com.midlife.exams.jpa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Content {


    public enum TestContentType{
        HOME,
        GROUP,
        EXAM,
        MODULE,
        PART,
        MARKDOWN,
        VIDEO,
        QUIZ
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long contentId;

    String name;
    String description;

    int positionInParentContent;

    @Enumerated(EnumType.STRING)
    TestContentType type;

    @ManyToOne
    Content parentContent;


    @OneToMany(mappedBy = "parentContent",fetch = FetchType.LAZY)
    List<Content> childContents;

    @OneToMany(mappedBy = "content",fetch = FetchType.LAZY)
    List<Additionaldata> additionalData;

    @OneToMany(mappedBy = "content",fetch = FetchType.LAZY)
    List<Question> questionList;

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

    public List<Additionaldata> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(List<Additionaldata> additionaldata) {
        this.additionalData = additionaldata;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public int getPositionInParentContent() {
        return positionInParentContent;
    }

    public void setPositionInParentContent(int positionInParentContent) {
        this.positionInParentContent = positionInParentContent;
    }
}

