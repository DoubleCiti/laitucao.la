package com.doubleciti.laitucao.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

public class UserSigninForm {
    @NotEmpty
    private String email = "";

    @NotEmpty
    @Min(6)
    private String password = "";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
