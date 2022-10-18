package com.example.demoyamaha1.service.impl;

import com.example.demoyamaha1.dto.UserDTO;
import com.example.demoyamaha1.repository.UserRepository;
import com.example.demoyamaha1.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(TicketLegalServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserById(int id) {
        return null;
    }

    @Override
    public List<UserDTO> findUserByCondition(String username, String email, String role, int status) {
        return null;
    }

//    @Override
//    public UserDetails getUserByUsernameOrEmailAndPassword(String username, String password) {
//        User user = userRepository.getByUsernameAndPassword(username,password) != null ?
//                    userRepository.getByUsernameAndPassword(username,password) :
//                    userRepository.getByEmailAndPassword(username, password);
//        return new UserPrinciple(user);
//    }
}
