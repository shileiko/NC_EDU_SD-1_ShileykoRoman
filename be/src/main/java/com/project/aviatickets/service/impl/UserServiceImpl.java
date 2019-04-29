package com.project.aviatickets.service.impl;

import com.project.aviatickets.model.Role;
import com.project.aviatickets.model.User;
import com.project.aviatickets.repository.RoleRepository;
import com.project.aviatickets.repository.UserRepository;
import com.project.aviatickets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User getById(Integer id){
        return userRepository.getOne(id);
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
