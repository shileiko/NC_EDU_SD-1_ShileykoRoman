package com.project.aviatickets.service;

import com.project.aviatickets.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User findByLogin(String login);
    List<User> getAll();
    User save(User user);
    User getById(Integer id);
    ResponseEntity delete(Integer id);
}
