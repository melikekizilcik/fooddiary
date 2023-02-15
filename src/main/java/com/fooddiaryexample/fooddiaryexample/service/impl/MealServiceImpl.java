package com.fooddiaryexample.fooddiaryexample.service.impl;

import com.fooddiaryexample.fooddiaryexample.model.Meal;
import com.fooddiaryexample.fooddiaryexample.repository.MealRepository;
import com.fooddiaryexample.fooddiaryexample.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {
    @Autowired
    private MealRepository mealRepository;
    @Override
    public Meal add(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @Override
    public Meal updateMeal(Long id, Meal meal) {
        Optional<Meal> resultMeal = mealRepository.findById(id);
        if (resultMeal.isPresent()){
            resultMeal.get().setMealName(meal.getMealName());
            resultMeal.get().setDateTime(meal.getDateTime());
            return mealRepository.save(meal);
        } else {
            return null;
        }


    }

    @Override
    public Meal deleteMeal(Long id) {
        Meal meal = mealRepository.findById(id).get();
        mealRepository.deleteById(id);
        return meal;
    }


}
