package com.doubleciti.laitucao.form;

import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserSigninFormValidator implements Validator {
    private final UserService userService;

    @Autowired
    public UserSigninFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserSigninForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserSigninForm form = (UserSigninForm) target;
        Optional<User> user = userService.getUserByEmail(form.getEmail());
        if (!user.isPresent() || user.get().getPassword() != new BCryptPasswordEncoder().encode(form.getPassword())) {
            errors.reject("email", "Email/Password combination doesn't match");
        }
    }
}
