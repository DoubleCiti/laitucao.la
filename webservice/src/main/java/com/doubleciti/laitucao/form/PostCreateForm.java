package com.doubleciti.laitucao.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

public class PostCreateForm {
    @NotEmpty
    @URL(protocol = "http")
    private String link;

    @NotEmpty
    private String title;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
