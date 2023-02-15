package com.fooddiaryexample.fooddiaryexample.controller;

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
    public MealList addMealList(@RequestBody MealList mealList){
        return mealListService.addMealList(mealList);
    }

    @GetMapping("/getall")
    public List<MealList> getAll(){
        return mealListService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public MealList deleteMealList(@PathVariable("id") Long id){
        return mealListService.deleteMealList(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<MealList> updateMealList(@PathVariable("id") Long id, @RequestBody MealList mealList){
        MealList updatedMealList = mealListService.updateMealList(id, mealList);
        return ResponseEntity.ok(updatedMealList);
    }
}
