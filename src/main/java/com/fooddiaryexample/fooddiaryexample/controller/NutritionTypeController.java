package com.fooddiaryexample.fooddiaryexample.controller;

import com.fooddiaryexample.fooddiaryexample.dto.NutritionTypeDto;
import com.fooddiaryexample.fooddiaryexample.model.NutritionType;
import com.fooddiaryexample.fooddiaryexample.service.NutritionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutritiontype")
public class NutritionTypeController {
    @Autowired
    private NutritionTypeService nutritionTypeService;

    //METHODLAR
    @PostMapping("/add")
    public NutritionTypeDto addNutritionType(@RequestBody NutritionTypeDto nutritionType){
        return nutritionTypeService.addNutritionType(nutritionType);
    }

    @GetMapping("/getall")
    public List<NutritionTypeDto> getAll(){
        return nutritionTypeService.getAll();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<NutritionTypeDto> updateNutritionType(@PathVariable("id") Long id, @RequestBody NutritionTypeDto nutritionType){
        NutritionTypeDto resultType = nutritionTypeService.updateNutritionType(id, nutritionType);
        return ResponseEntity.ok(resultType);
    }

    @DeleteMapping("/delete/{id}")
    public NutritionTypeDto deleteNutritionType(@PathVariable("id") Long id){
        return nutritionTypeService.deleteNutritionType(id);
    }

}
