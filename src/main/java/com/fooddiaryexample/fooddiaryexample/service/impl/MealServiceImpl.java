package com.fooddiaryexample.fooddiaryexample.service.impl;

import com.fooddiaryexample.fooddiaryexample.dto.MealDto;
import com.fooddiaryexample.fooddiaryexample.model.Meal;
import com.fooddiaryexample.fooddiaryexample.repository.MealRepository;
import com.fooddiaryexample.fooddiaryexample.service.MealService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public MealDto add(MealDto mealDto) {
        Meal meal = modelMapper.map(mealDto, Meal.class);
        return modelMapper.map(mealRepository.save(meal), MealDto.class);
    }

    @Override
    public List<MealDto> getAll() {
        List<Meal> meals = mealRepository.findAll();
        List<MealDto> mealDtos = meals.stream().map(meal -> modelMapper.map(meal, MealDto.class)).collect(Collectors.toList());

        return mealDtos;
    }

    @Override
    public MealDto updateMeal(Long id, MealDto meal) {
        Optional<Meal> resultMeal = mealRepository.findById(id);
        if (resultMeal.isPresent()){
            resultMeal.get().setMealName(meal.getMealName());
            resultMeal.get().setDateTime(meal.getDateTime());
            return modelMapper.map(mealRepository.save(resultMeal.get()), MealDto.class);
        } else {
            return null;
        }


    }

    @Override
    public MealDto deleteMeal(Long id) {
        Meal meal = mealRepository.findById(id).get();
        mealRepository.deleteById(id);
        return modelMapper.map(meal, MealDto.class);
    }


}
