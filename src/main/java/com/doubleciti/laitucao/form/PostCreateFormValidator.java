package com.doubleciti.laitucao.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PostCreateFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PostCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
