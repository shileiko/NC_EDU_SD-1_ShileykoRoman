package com.project.aviatickets.service;

import com.project.aviatickets.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    List<User> getAll();
    User save(User user);
    User getById(Integer id);
    ResponseEntity delete(Integer id);
    User update(User user);
}
