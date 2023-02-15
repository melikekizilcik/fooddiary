package com.fooddiaryexample.fooddiaryexample.service;

import com.fooddiaryexample.fooddiaryexample.model.MealList;

import java.util.List;

public interface MealListService {
    MealList addMealList(MealList mealList);

    List<MealList> getAll();

    MealList deleteMealList(Long id);

    MealList updateMealList(Long id, MealList mealList);
}
