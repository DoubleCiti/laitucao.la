package com.doubleciti.laitucao.domain;

import javax.persistence.Id;

public class Post {

    @Id
    private Long id;

    private String link;

    public Long getId() {
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
