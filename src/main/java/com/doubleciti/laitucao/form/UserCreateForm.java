package com.doubleciti.laitucao.form;

import com.doubleciti.laitucao.domain.Role;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCreateForm {
    @NotEmpty
    @Email
    private String email = "";

    @NotEmpty
    @Size(min = 5, max = 12)
    private String username = "";

    @NotEmpty
    @Size(min = 6, max = 12)
    private String password = "";

    @NotEmpty
    @Size(min = 6, max = 12)
    private String passwordRepeated = "";

    @NotNull
    private Role role = Role.USER;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public String getUsername() {
        return username;
    }
}
