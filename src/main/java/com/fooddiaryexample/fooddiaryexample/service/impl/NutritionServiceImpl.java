package com.fooddiaryexample.fooddiaryexample.service.impl;

import com.fooddiaryexample.fooddiaryexample.dto.NutritionDto;
import com.fooddiaryexample.fooddiaryexample.dto.NutritionTypeDto;
import com.fooddiaryexample.fooddiaryexample.model.Nutrition;
import com.fooddiaryexample.fooddiaryexample.repository.NutritionRepository;
import com.fooddiaryexample.fooddiaryexample.service.NutritionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NutritionServiceImpl implements NutritionService {
    @Autowired
    private NutritionRepository nutritionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public NutritionDto addNutrition(NutritionDto nutritionDto) {
        Nutrition nutrition = modelMapper.map(nutritionDto, Nutrition.class);


        return modelMapper.map(nutritionRepository.save(nutrition), NutritionDto.class);
    }

    @Override
    public List<NutritionDto> getAll() {
        List<Nutrition> nutritions = nutritionRepository.findAll();
        List<NutritionDto> nutritionDtos = nutritions.stream().map(nutrition -> modelMapper.map(nutrition, NutritionDto.class)).collect(Collectors.toList());
        return nutritionDtos;
    }

    @Override
    public NutritionDto deleteNutrition(Long id) {
       Nutrition deletedNutrition = nutritionRepository.findById(id).get();
       nutritionRepository.deleteById(id);
        return modelMapper.map(deletedNutrition, NutritionDto.class);
    }

    @Override
    public NutritionDto updateNutrition(Long id, NutritionDto nutrition) {
        Optional<Nutrition> resultNutrition = nutritionRepository.findById(id);
        if(resultNutrition.isPresent()){
            resultNutrition.get().setNutritionName(nutrition.getNutritionName());
            resultNutrition.get().setNutritionType(nutrition.getNutritionType());
            resultNutrition.get().setKcal(nutrition.getKcal());
            resultNutrition.get().setFat(nutrition.getFat());
            resultNutrition.get().setCarbonhydrate(nutrition.getCarbonhydrate());
            resultNutrition.get().setProtein(nutrition.getProtein());
            return modelMapper.map(nutritionRepository.save(resultNutrition.get()), NutritionDto.class);
        } else{
            return null;
        }

    }


}
