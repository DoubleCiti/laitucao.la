package com.doubleciti.laitucao.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import com.doubleciti.laitucao.model.UserInfo;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "created_at")
    @Builder.Default
    private java.sql.Timestamp createdAt = new Timestamp(new Date().getTime());

    @Column(name = "updated_at")
    @Builder.Default
    private java.sql.Timestamp updatedAt = new Timestamp(new Date().getTime());

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Post> posts;

    @Override
    public String toString() {
        return String.format("User[id=%s, email=%s]", id, email);
    }

    public UserInfo toUserInfo() {
        return UserInfo.builder()
                .id(id)
                .email(email)
                .username(username)
                .role(role)
                .build();
    }
}
