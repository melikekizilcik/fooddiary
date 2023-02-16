package com.fooddiaryexample.fooddiaryexample.service;

import com.fooddiaryexample.fooddiaryexample.dto.NutritionTypeDto;
import com.fooddiaryexample.fooddiaryexample.model.NutritionType;

import java.util.List;

public interface NutritionTypeService {

    NutritionTypeDto addNutritionType(NutritionTypeDto nutritionType);

    List<NutritionTypeDto> getAll();

    NutritionTypeDto updateNutritionType(Long id,NutritionTypeDto nutritionType);

    NutritionTypeDto deleteNutritionType(Long id);
}
