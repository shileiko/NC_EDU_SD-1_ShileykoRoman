package com.project.aviatickets.controller;

import com.project.aviatickets.models.User;
import com.project.aviatickets.security.TokenProvider;
import com.project.aviatickets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenUtil;

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(value = "/username")
    public User getUsername(@RequestHeader("Authorization") String token){
        String usernameFromToken = tokenUtil.getUsernameFromToken(token);
        return userService.findByUsername(usernameFromToken);
    }
}

