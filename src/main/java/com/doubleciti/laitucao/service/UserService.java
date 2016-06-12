package com.doubleciti.laitucao.service;

import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.forms.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);
}
