package com.fooddiaryexample.fooddiaryexample.dto;

import com.fooddiaryexample.fooddiaryexample.model.NutritionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionDto {
    private String nutritionName;
    private Double kcal;
    private Double protein;
    private Double fat;
    private Double carbonhydrate;
    private NutritionType nutritionType;
}
