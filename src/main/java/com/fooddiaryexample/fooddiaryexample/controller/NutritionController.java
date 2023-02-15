package com.fooddiaryexample.fooddiaryexample.controller;

import com.fooddiaryexample.fooddiaryexample.model.Nutrition;
import com.fooddiaryexample.fooddiaryexample.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutrition")
public class NutritionController {

    @Autowired
    private NutritionService nutritionService;

    @PostMapping("/add")
    public Nutrition addNutrition(@RequestBody Nutrition nutrition){
        return nutritionService.addNutrition(nutrition);
    }

    @GetMapping("/getall")
    public List<Nutrition> getAll(){
        return nutritionService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public Nutrition deleteNutrition(@PathVariable("id") Long id){
        return nutritionService.deleteNutrition(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Nutrition> updateNutrition(@PathVariable("id") Long id, @RequestBody Nutrition nutrition){
        Nutrition updatedNutrition = nutritionService.updateNutrition(id, nutrition);
        return ResponseEntity.ok(updatedNutrition);
    }
}
