package com.doubleciti.laitucao.service;

import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.model.SignInInfo;
import com.doubleciti.laitucao.model.SignUpInfo;
import com.doubleciti.laitucao.model.UserInfo;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    UserInfo create(SignUpInfo form);

    UserInfo signIn(final SignInInfo info);
}
