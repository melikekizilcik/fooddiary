package com.fooddiaryexample.fooddiaryexample.service;

import com.fooddiaryexample.fooddiaryexample.dto.NutritionDto;
import com.fooddiaryexample.fooddiaryexample.model.Nutrition;

import java.util.List;

public interface NutritionService {
    NutritionDto addNutrition(NutritionDto nutrition);

    List<NutritionDto> getAll();

    NutritionDto deleteNutrition(Long id);

    NutritionDto updateNutrition(Long id, NutritionDto nutrition);
}
