package com.fooddiaryexample.fooddiaryexample.service.impl;

import com.fooddiaryexample.fooddiaryexample.model.NutritionType;
import com.fooddiaryexample.fooddiaryexample.model.User;
import com.fooddiaryexample.fooddiaryexample.repository.NutritionTypeRepository;
import com.fooddiaryexample.fooddiaryexample.service.NutritionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionTypeServiceImpl implements NutritionTypeService {
    @Autowired
    private NutritionTypeRepository nutritionTypeRepository;
    @Override
    public NutritionType addNutritionType(NutritionType nutritionType) {
        return nutritionTypeRepository.save(nutritionType);
    }

    @Override
    public List<NutritionType> getAll() {
        return nutritionTypeRepository.findAll();
    }

    @Override
    public NutritionType updateNutritionType(Long id, NutritionType nutritionType) {
        Optional<NutritionType> resultType = nutritionTypeRepository.findById(id);
        if(resultType.isPresent()){
            resultType.get().setType(nutritionType.getType());
            return nutritionTypeRepository.save(resultType.get());

        } else {
            return null;
        }
    }

    @Override
    public NutritionType deleteNutritionType(Long id) {
        NutritionType deletedType = nutritionTypeRepository.findById(id).get();
        nutritionTypeRepository.deleteById(id);
        return deletedType;
    }
}
