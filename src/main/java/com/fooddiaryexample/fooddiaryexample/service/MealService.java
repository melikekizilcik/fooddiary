package com.fooddiaryexample.fooddiaryexample.service;

import com.fooddiaryexample.fooddiaryexample.dto.MealDto;
import com.fooddiaryexample.fooddiaryexample.model.Meal;

import java.util.List;

public interface MealService {
    MealDto add(MealDto meal);

    List<MealDto> getAll();

    MealDto updateMeal(Long id, MealDto meal);

    MealDto deleteMeal(Long id);
}
