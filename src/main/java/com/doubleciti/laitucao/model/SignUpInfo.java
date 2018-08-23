package com.doubleciti.laitucao.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignUpInfo {
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
}
