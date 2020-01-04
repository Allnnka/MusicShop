package com.allnnka.firstspringproject.service;


import com.allnnka.firstspringproject.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    void save(User user);

    User findByUsername(String username);
}
