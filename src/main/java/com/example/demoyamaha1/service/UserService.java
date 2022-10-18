package com.example.demoyamaha1.service;

import com.example.demoyamaha1.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    UserDTO getUserById(int id);
    List<UserDTO> findUserByCondition(String username, String email, String role, int status);
 //   UserDetails getUserByUsernameOrEmailAndPassword(String username, String password);
}
