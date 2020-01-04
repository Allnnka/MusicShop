package com.allnnka.firstspringproject.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
