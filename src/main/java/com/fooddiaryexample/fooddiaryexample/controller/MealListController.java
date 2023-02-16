package com.fooddiaryexample.fooddiaryexample.controller;

import com.fooddiaryexample.fooddiaryexample.dto.MealListDto;
import com.fooddiaryexample.fooddiaryexample.model.Meal;
import com.fooddiaryexample.fooddiaryexample.model.MealList;
import com.fooddiaryexample.fooddiaryexample.service.MealListService;
import com.fooddiaryexample.fooddiaryexample.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meallist")
public class MealListController {
    @Autowired
    private MealListService mealListService;

    @PutMapping("/add")
    public MealListDto addMealList(@RequestBody MealListDto mealList){
        return mealListService.addMealList(mealList);
    }

    @GetMapping("/getall")
    public List<MealListDto> getAll(){
        return mealListService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public MealListDto deleteMealList(@PathVariable("id") Long id){
        return mealListService.deleteMealList(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<MealListDto> updateMealList(@PathVariable("id") Long id, @RequestBody MealListDto mealList){
        MealListDto updatedMealList = mealListService.updateMealList(id, mealList);
        return ResponseEntity.ok(updatedMealList);
    }
}
