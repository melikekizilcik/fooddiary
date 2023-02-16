package com.fooddiaryexample.fooddiaryexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {
    private String mealName;
    private LocalDateTime dateTime;
}
