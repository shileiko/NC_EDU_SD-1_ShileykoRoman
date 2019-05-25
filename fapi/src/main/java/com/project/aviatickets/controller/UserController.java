package com.project.aviatickets.controller;

import com.project.aviatickets.models.User;
import com.project.aviatickets.security.TokenProvider;
import com.project.aviatickets.service.UserService;
import com.project.aviatickets.service.impl.UserServiceImpl;
import com.project.aviatickets.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TokenProvider tokenUtil;

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(value = "/username")
    public User getUsername(@RequestHeader("Authorization") String token){
        String usernameFromToken = tokenUtil.getUsernameFromToken(token);
        return userService.findByUsername(usernameFromToken);
    }


    @PostMapping
    public ResponseEntity saveUser(@RequestBody @Valid User user, BindingResult bindingResult){
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(userService.save(user));
    }
}

