package com.fooddiaryexample.fooddiaryexample.service.impl;

import com.fooddiaryexample.fooddiaryexample.model.Nutrition;
import com.fooddiaryexample.fooddiaryexample.repository.NutritionRepository;
import com.fooddiaryexample.fooddiaryexample.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionServiceImpl implements NutritionService {
    @Autowired
    private NutritionRepository nutritionRepository;
    @Override
    public Nutrition addNutrition(Nutrition nutrition) {
        return nutritionRepository.save(nutrition);
    }

    @Override
    public List<Nutrition> getAll() {
        return nutritionRepository.findAll();
    }

    @Override
    public Nutrition deleteNutrition(Long id) {
       Nutrition deletedNutrition = nutritionRepository.findById(id).get();
       nutritionRepository.deleteById(id);
        return deletedNutrition;
    }

    @Override
    public Nutrition updateNutrition(Long id, Nutrition nutrition) {
        Optional<Nutrition> resultNutrition = nutritionRepository.findById(id);
        if(resultNutrition.isPresent()){
            resultNutrition.get().setNutritionName(nutrition.getNutritionName());
            resultNutrition.get().setNutritionType(nutrition.getNutritionType());
            resultNutrition.get().setKcal(nutrition.getKcal());
            resultNutrition.get().setFat(nutrition.getFat());
            resultNutrition.get().setCarbonhydrate(nutrition.getCarbonhydrate());
            resultNutrition.get().setProtein(nutrition.getProtein());
            return nutritionRepository.save(nutrition);
        } else{
            return null;
        }

    }


}
