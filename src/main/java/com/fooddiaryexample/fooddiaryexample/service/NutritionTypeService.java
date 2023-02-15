package com.fooddiaryexample.fooddiaryexample.service;

import com.fooddiaryexample.fooddiaryexample.model.NutritionType;

import java.util.List;

public interface NutritionTypeService {

    NutritionType addNutritionType(NutritionType nutritionType);

    List<NutritionType> getAll();

    NutritionType updateNutritionType(Long id,NutritionType nutritionType);

    NutritionType deleteNutritionType(Long id);
}
