package com.fooddiaryexample.fooddiaryexample.service.impl;

import com.fooddiaryexample.fooddiaryexample.config.ModelMapperConfig;
import com.fooddiaryexample.fooddiaryexample.dto.UserDto;
import com.fooddiaryexample.fooddiaryexample.model.User;
import com.fooddiaryexample.fooddiaryexample.repository.UserRepository;
import com.fooddiaryexample.fooddiaryexample.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto addUser(UserDto userDto) {
    User user = modelMapper.map(userDto, User.class);

        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        Optional<User> resultUser = userRepository.findById(id);
        if(resultUser.isPresent()){
            resultUser.get().setFirstName(user.getFirstName());
            resultUser.get().setLastName(user.getLastName());
            resultUser.get().setWeight(user.getWeight());
            resultUser.get().setAge(user.getAge());
            resultUser.get().setHeight(user.getHeight());
            return modelMapper.map(userRepository.save(resultUser.get()), UserDto.class);
        } else {
            return null;
        }
    }


    @Override
    public UserDto deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return modelMapper.map(user, UserDto.class);

    }
}
