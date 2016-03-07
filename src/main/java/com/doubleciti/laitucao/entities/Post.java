package com.doubleciti.laitucao.entities;

import org.springframework.data.annotation.Id;

public class Post {
    @Id
    private String id;

    private String link;

    public String getId() {
        return id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public Post() {}

    public Post(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return String.format("Post[id=%s, link=%s]", id, link);
    }

}
