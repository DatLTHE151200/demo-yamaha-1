package com.example.demoyamaha1.authentication.user;

import com.example.demoyamaha1.entity.User;
import com.example.demoyamaha1.service.BaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface ICustomUserService extends BaseService<User> ,UserDetailsService {
    Optional<User> findByUsername(String username);
}
