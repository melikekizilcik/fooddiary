package com.fooddiaryexample.fooddiaryexample.repository;

import com.fooddiaryexample.fooddiaryexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
