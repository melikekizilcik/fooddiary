package com.fooddiaryexample.fooddiaryexample.service;

import com.fooddiaryexample.fooddiaryexample.model.Nutrition;

import java.util.List;

public interface NutritionService {
    Nutrition addNutrition(Nutrition nutrition);

    List<Nutrition> getAll();

    Nutrition deleteNutrition(Long id);

    Nutrition updateNutrition(Long id, Nutrition nutrition);
}
