package com.project.aviatickets.validators;

import com.project.aviatickets.models.User;
import com.project.aviatickets.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserValidator implements Validator {

    private final UserServiceImpl userService;

    @Autowired
    public UserValidator(UserServiceImpl userService) {
        this.userService = userService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        Matcher matcher = Pattern.compile("^(.+)@(.+)$").matcher(user.getEmail());
        if (!matcher.matches()) {
            errors.rejectValue("email", "Please enter valid email");
        }
        if (user.getPassword().length() < 4) {
            errors.rejectValue("password", "Password should be more than 4 characters");
        }
        User u = userService.findByUsername(user.getUsername());
        if (!(u == null)) {
            errors.rejectValue("username", "User with that username is already exists");
        }
        User usercheck = userService.findByEmail(user.getEmail());
        if (!(usercheck == null)) {
            errors.rejectValue("email", "User with that email is already exists");
        }
    }

}
