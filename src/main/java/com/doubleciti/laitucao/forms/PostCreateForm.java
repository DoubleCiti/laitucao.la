package com.doubleciti.laitucao.forms;

import org.hibernate.validator.constraints.NotEmpty;

public class PostCreateForm {
    @NotEmpty
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
