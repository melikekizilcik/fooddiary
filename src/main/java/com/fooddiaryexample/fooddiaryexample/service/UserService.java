package com.fooddiaryexample.fooddiaryexample.service;

import com.fooddiaryexample.fooddiaryexample.dto.UserDto;
import com.fooddiaryexample.fooddiaryexample.model.User;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto user);

    List<UserDto> getAll();

    UserDto updateUser(Long id, UserDto user);

    UserDto deleteUser(Long id);
}
