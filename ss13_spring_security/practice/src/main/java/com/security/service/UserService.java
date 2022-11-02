package com.security.service;

import com.security.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);
}
