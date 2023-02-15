package com.fooddiaryexample.fooddiaryexample.service;

import com.fooddiaryexample.fooddiaryexample.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> getAll();

    User updateUser(Long id, User user);

    User deleteUser(Long id);
}
