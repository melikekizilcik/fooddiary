package com.fooddiaryexample.fooddiaryexample.dto;

import com.fooddiaryexample.fooddiaryexample.model.Meal;
import com.fooddiaryexample.fooddiaryexample.model.Nutrition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealListDto {
    private Meal meal;
    private Nutrition nutrition;
}
