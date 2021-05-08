package com.example.shopspring.services.security;

public interface SecurityService {

    String findLoggedInUsername();
    void autoLogin(String username, String password);

}
