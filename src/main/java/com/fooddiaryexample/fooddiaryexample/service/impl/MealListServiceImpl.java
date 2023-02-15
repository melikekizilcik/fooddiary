package com.fooddiaryexample.fooddiaryexample.service.impl;

import com.fooddiaryexample.fooddiaryexample.model.MealList;
import com.fooddiaryexample.fooddiaryexample.repository.MealListRepository;
import com.fooddiaryexample.fooddiaryexample.service.MealListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealListServiceImpl implements MealListService {

    @Autowired
    private MealListRepository mealListRepository;


    @Override
    public MealList addMealList(MealList mealList) {
        return mealListRepository.save(mealList);
    }

    @Override
    public List<MealList> getAll() {
        return mealListRepository.findAll();
    }

    @Override
    public MealList deleteMealList(Long id) {
        MealList deletedMealList = mealListRepository.findById(id).get();
        mealListRepository.deleteById(id);
        return deletedMealList;
    }

    @Override
    public MealList updateMealList(Long id, MealList mealList) {
        Optional<MealList> updatedMealList = mealListRepository.findById(id);
        if(updatedMealList.isPresent()){
            updatedMealList.get().setMeal(mealList.getMeal());
            updatedMealList.get().setNutrition(mealList.getNutrition());
            return mealListRepository.save(updatedMealList.get());
        } else{
        return null;
    }}


}
