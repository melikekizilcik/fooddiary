package com.fooddiaryexample.fooddiaryexample.service.impl;

import com.fooddiaryexample.fooddiaryexample.model.User;
import com.fooddiaryexample.fooddiaryexample.repository.UserRepository;
import com.fooddiaryexample.fooddiaryexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> resultUser = userRepository.findById(id);
        if(resultUser.isPresent()){
            resultUser.get().setFirstName(user.getFirstName());
            resultUser.get().setLastName(user.getLastName());
            resultUser.get().setWeight(user.getWeight());
            return userRepository.save(resultUser.get());
        } else {
            return null;
        }
    }


    @Override
    public User deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return user;

    }
}
