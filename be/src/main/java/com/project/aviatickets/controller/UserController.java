package com.project.aviatickets.controller;

import com.project.aviatickets.model.Role;
import com.project.aviatickets.model.User;
import com.project.aviatickets.repository.RoleRepository;
import com.project.aviatickets.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usersba")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") Integer userId){
        User user = this.userService.getById(userId);

        if (user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody @Valid User user){
        Role roleUser = roleRepository.findByName("USER");
        user.setRole(roleUser);

        if (user == null){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }

        this.userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser (@PathVariable("id") Integer id){
        User user = this.userService.getById(id);

        if (user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        this.userService.delete(id);

        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAll();

        if (users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
