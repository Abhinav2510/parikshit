package com.midlife.exams.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Additionaldata implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "content_id")
    Content content;
    @Id
    String key;
    String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

