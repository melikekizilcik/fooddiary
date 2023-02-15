package com.fooddiaryexample.fooddiaryexample.controller;

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
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public User add(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        User resultUser = userService.updateUser(id, user);
        return ResponseEntity.ok(resultUser);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
