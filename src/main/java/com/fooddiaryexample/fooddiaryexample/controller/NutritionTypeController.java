package com.fooddiaryexample.fooddiaryexample.controller;

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
    public NutritionType addNutritionType(@RequestBody NutritionType nutritionType){
        return nutritionTypeService.addNutritionType(nutritionType);
    }

    @GetMapping("/getall")
    public List<NutritionType> getAll(){
        return nutritionTypeService.getAll();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<NutritionType> updateNutritionType(@PathVariable("id") Long id, @RequestBody NutritionType nutritionType){
        NutritionType resultType = nutritionTypeService.updateNutritionType(id, nutritionType);
        return ResponseEntity.ok(resultType);
    }

    @DeleteMapping("/delete/{id}")
    public NutritionType deleteNutritionType(@PathVariable("id") Long id){
        return nutritionTypeService.deleteNutritionType(id);
    }

}
