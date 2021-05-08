package com.example.shopspring.services.user;

import com.example.shopspring.representations.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
