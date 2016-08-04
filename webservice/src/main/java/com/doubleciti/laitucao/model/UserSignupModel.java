package com.doubleciti.laitucao.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@JsonAutoDetect
public class UserSignupModel {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 5, max = 12)
    private String username;

    @NotEmpty
    @Size(min = 6, max = 12)
    private String password;

    @NotEmpty
    @Size(min = 6, max = 12)
    private String passwordRepeated;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }
}
