package com.iptgroup.BadgerFight.dto;

import com.iptgroup.BadgerFight.role.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDTO {
    private String username;
    private String password;
    private Role role = Role.USER;
}
