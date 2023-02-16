package com.fooddiaryexample.fooddiaryexample.service.impl;

import com.fooddiaryexample.fooddiaryexample.dto.MealListDto;
import com.fooddiaryexample.fooddiaryexample.model.MealList;
import com.fooddiaryexample.fooddiaryexample.repository.MealListRepository;
import com.fooddiaryexample.fooddiaryexample.service.MealListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MealListServiceImpl implements MealListService {

    @Autowired
    private MealListRepository mealListRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public MealListDto addMealList(MealListDto mealListDto) {
        MealList mealList = modelMapper.map(mealListDto, MealList.class);
        return modelMapper.map(mealListRepository.save(mealList), MealListDto.class);
    }

    @Override
    public List<MealListDto> getAll() {
        List<MealList> mealLists = mealListRepository.findAll();
        List<MealListDto> mealListDtos = mealLists.stream().map(mealList -> modelMapper.map(mealList, MealListDto.class)).collect(Collectors.toList());
        return mealListDtos ;
    }

    @Override
    public MealListDto deleteMealList(Long id) {
        MealList deletedMealList = mealListRepository.findById(id).get();
        mealListRepository.deleteById(id);
        return modelMapper.map(deletedMealList, MealListDto.class);
    }

    @Override
    public MealListDto updateMealList(Long id, MealListDto mealList) {
        Optional<MealList> updatedMealList = mealListRepository.findById(id);
        if(updatedMealList.isPresent()){
            updatedMealList.get().setMeal(mealList.getMeal());
            updatedMealList.get().setNutrition(mealList.getNutrition());
            return modelMapper.map(mealListRepository.save(updatedMealList.get()), MealListDto.class);
        } else{
        return null;
    }}


}
