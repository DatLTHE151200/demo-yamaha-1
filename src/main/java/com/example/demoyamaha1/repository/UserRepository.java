package com.example.demoyamaha1.repository;

import com.example.demoyamaha1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsernameAndPassword(String username, String password);

    User getByEmailAndPassword(String email, String password);

    User getByEmail(String Email);

    Optional<User> findByUsername(String username);
}
