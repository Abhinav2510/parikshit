package com.midlife.exams.jpa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class TestContentPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long testContentPartId;

    String name;
    String description;

    @OneToMany(mappedBy = "part")
    List<Question> questionsList;

    @ManyToOne
    Content content;

    public long getTestContentPartId() {
        return testContentPartId;
    }

    public void setTestContentPartId(long testContentPartId) {
        this.testContentPartId = testContentPartId;
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

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
