package com.fooddiaryexample.fooddiaryexample.controller;

import com.fooddiaryexample.fooddiaryexample.dto.NutritionDto;
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
    public NutritionDto addNutrition(@RequestBody NutritionDto nutrition){
        return nutritionService.addNutrition(nutrition);
    }

    @GetMapping("/getall")
    public List<NutritionDto> getAll(){
        return nutritionService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public NutritionDto deleteNutrition(@PathVariable("id") Long id){
        return nutritionService.deleteNutrition(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<NutritionDto> updateNutrition(@PathVariable("id") Long id, @RequestBody NutritionDto nutrition){
        NutritionDto updatedNutrition = nutritionService.updateNutrition(id, nutrition);
        return ResponseEntity.ok(updatedNutrition);
    }
}
