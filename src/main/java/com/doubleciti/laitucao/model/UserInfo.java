package com.doubleciti.laitucao.model;

import com.doubleciti.laitucao.domain.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {
    private Long id;

    private String email;

    private String username;

    private Role role;
}
