package com.fooddiaryexample.fooddiaryexample.controller;

import com.fooddiaryexample.fooddiaryexample.dto.UserDto;
import com.fooddiaryexample.fooddiaryexample.model.User;
import com.fooddiaryexample.fooddiaryexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //METHODLAR:
    @GetMapping("/getall")
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public UserDto add(@RequestBody UserDto user){
        return userService.addUser(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto user){
        UserDto resultUser = userService.updateUser(id, user);
        return ResponseEntity.ok(resultUser);
    }

    @DeleteMapping("/delete/{id}")
    public UserDto deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
