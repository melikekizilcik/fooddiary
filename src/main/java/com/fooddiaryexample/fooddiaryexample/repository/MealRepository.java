package com.fooddiaryexample.fooddiaryexample.repository;

import com.fooddiaryexample.fooddiaryexample.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
