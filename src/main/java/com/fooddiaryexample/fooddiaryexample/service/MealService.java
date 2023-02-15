package com.fooddiaryexample.fooddiaryexample.service;

import com.fooddiaryexample.fooddiaryexample.model.Meal;

import java.util.List;

public interface MealService {
    Meal add(Meal meal);

    List<Meal> getAll();

    Meal updateMeal(Long id, Meal meal);

    Meal deleteMeal(Long id);
}
