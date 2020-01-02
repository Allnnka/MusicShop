package com.allnnka.firstspringproject.controller;


import com.allnnka.firstspringproject.model.Role;
import com.allnnka.firstspringproject.model.User;
import com.allnnka.firstspringproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration( Map<String, Object> model) {
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user){
//        User userFromDb=userRepository.findByUsername(user.getUsername());
//        if(userFromDb!=null){
//            model.put("message","user exists!");
//            return "registration";
//        }
        user.setActive(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
