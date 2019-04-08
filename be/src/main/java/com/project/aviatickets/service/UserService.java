package com.project.aviatickets.service;

import com.project.aviatickets.model.User;

import java.util.List;

public interface UserService {
    public User getById(Integer id);

    public void save(User user);

    public void delete(Integer id);

    public List<User> getAll();
}
