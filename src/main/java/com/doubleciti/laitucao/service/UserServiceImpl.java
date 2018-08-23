package com.doubleciti.laitucao.service;

import java.util.Collection;
import java.util.Optional;

import com.doubleciti.laitucao.domain.Role;
import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.model.SignInInfo;
import com.doubleciti.laitucao.model.SignUpInfo;
import com.doubleciti.laitucao.model.UserInfo;
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
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(final String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll(Sort.by("email"));
    }

    @Override
    public UserInfo create(final SignUpInfo info) {
        final Optional<User> userOptional = userRepository.findOneByEmail(info.getEmail());

        if (userOptional.isPresent()) {
            return null;
        }

        final User user = User.builder()
                .email(info.getEmail())
                .password(new BCryptPasswordEncoder().encode(info.getPassword()))
                .role(Role.USER)
                .username(info.getUsername())
                .build();

        return userRepository.save(user).toUserInfo();
    }

    @Override
    public UserInfo signIn(final SignInInfo info) {
        final Optional<User> user = userRepository.findOneByEmail(info.getEmail());

        if (!user.isPresent() ||
                !user.get().getPassword().equals(new BCryptPasswordEncoder().encode(info.getPassword()))) {
            return null;
        }

        return user.get().toUserInfo();
    }
}
