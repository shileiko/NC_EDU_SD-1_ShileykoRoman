package com.project.aviatickets.service;

import com.project.aviatickets.models.User;

import java.util.List;

public interface UserService {
    User findByLogin(String login);
    List<User> findAll();
    User save(User user);
}
