package com.olsproject.onlinelotterysystem.service;

import com.olsproject.onlinelotterysystem.entity.User;
import com.olsproject.onlinelotterysystem.error.CannotRegister;
import com.olsproject.onlinelotterysystem.error.MoreUsersRequired;

import java.util.List;

public interface UserService {
    public User registerUser(User user) throws CannotRegister;

    public List<User> fetchAllUsers();

    public List<User> pickWinners() throws MoreUsersRequired;
}
