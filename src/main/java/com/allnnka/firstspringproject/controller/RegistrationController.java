package com.allnnka.firstspringproject.controller;

import com.allnnka.firstspringproject.model.User;
import com.allnnka.firstspringproject.service.SecurityService;
import com.allnnka.firstspringproject.service.UserService;
import com.allnnka.firstspringproject.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private UserService userService;
    private SecurityService securityService;
    private UserValidator userValidator;

    public RegistrationController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @GetMapping("/registration")
    public String registration(User user) {

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
