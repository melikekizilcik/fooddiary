package com.fooddiaryexample.fooddiaryexample.controller;

import com.fooddiaryexample.fooddiaryexample.model.Meal;
import com.fooddiaryexample.fooddiaryexample.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    private MealService mealService;

    @PostMapping("/add")
    public Meal addMeal(@RequestBody Meal meal){
        return mealService.add(meal);
    }

    @GetMapping("/getall")
    public List<Meal> getAll(){
        return mealService.getAll();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Meal> updateMeal(@PathVariable("id") Long id, @RequestBody Meal meal){
        Meal updatedMeal = mealService.updateMeal(id,meal);
        return ResponseEntity.ok(updatedMeal);
    }

    @DeleteMapping("/delete/{id}")
    public Meal deleteMeal(@PathVariable("id") Long id){
        return mealService.deleteMeal(id);
    }
}
