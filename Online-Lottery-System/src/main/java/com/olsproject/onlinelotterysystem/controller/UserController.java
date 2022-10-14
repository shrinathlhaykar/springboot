package com.olsproject.onlinelotterysystem.controller;

import com.olsproject.onlinelotterysystem.entity.User;
import com.olsproject.onlinelotterysystem.error.CannotRegister;
import com.olsproject.onlinelotterysystem.error.MoreUsersRequired;
import com.olsproject.onlinelotterysystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/ols/register")
    public User registerUser(@RequestBody User user) throws CannotRegister {
        return userService.registerUser(user);
    }

    @GetMapping("/ols/allusers")
    public ResponseEntity<List<User>> fetchAllUsers(){
        return ResponseEntity.badRequest().body(userService.fetchAllUsers());
    }

    @GetMapping("/ols/pickWinners")

    public List<User> pickWinners() throws MoreUsersRequired {
        return  userService.pickWinners();
    }
}
