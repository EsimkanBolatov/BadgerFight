package com.iptgroup.BadgerFight.services;

import com.iptgroup.BadgerFight.entity.UserEntity;
import com.iptgroup.BadgerFight.repository.UserRepository;
import com.iptgroup.BadgerFight.role.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity registerUser(String username, String password, Role role) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role); // Назначаем роль

        return userRepository.save(user);
    }
}
