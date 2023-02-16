package com.fooddiaryexample.fooddiaryexample.service;

import com.fooddiaryexample.fooddiaryexample.dto.MealListDto;
import com.fooddiaryexample.fooddiaryexample.model.MealList;

import java.util.List;

public interface MealListService {
    MealListDto addMealList(MealListDto mealList);

    List<MealListDto> getAll();

    MealListDto deleteMealList(Long id);

    MealListDto updateMealList(Long id, MealListDto mealList);
}
