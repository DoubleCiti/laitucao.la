package com.doubleciti.laitucao.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.form.UserCreateForm;
import com.doubleciti.laitucao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        user.setUsername(form.getUsername());
        Timestamp now = new Timestamp(new Date().getTime());
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        return userRepository.save(user);
    }
}
