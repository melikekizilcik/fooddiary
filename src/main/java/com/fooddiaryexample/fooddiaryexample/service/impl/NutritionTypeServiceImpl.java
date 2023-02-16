package com.fooddiaryexample.fooddiaryexample.service.impl;

import com.fooddiaryexample.fooddiaryexample.dto.NutritionTypeDto;
import com.fooddiaryexample.fooddiaryexample.model.NutritionType;
import com.fooddiaryexample.fooddiaryexample.model.User;
import com.fooddiaryexample.fooddiaryexample.repository.NutritionTypeRepository;
import com.fooddiaryexample.fooddiaryexample.service.NutritionTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NutritionTypeServiceImpl implements NutritionTypeService {
    @Autowired
    private NutritionTypeRepository nutritionTypeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public NutritionTypeDto addNutritionType(NutritionTypeDto nutritionTypeDto) {
        NutritionType nutritionType = modelMapper.map(nutritionTypeDto, NutritionType.class);
        return modelMapper.map(nutritionTypeRepository.save(nutritionType), NutritionTypeDto.class);
    }

    @Override
    public List<NutritionTypeDto> getAll() {
        List<NutritionType> nutritionTypes = nutritionTypeRepository.findAll();
        List<NutritionTypeDto> nutritionTypeDtos = nutritionTypes.stream().map(nutritionType -> modelMapper.map(nutritionType, NutritionTypeDto.class)).collect(Collectors.toList());

        return nutritionTypeDtos;
    }

    @Override
    public NutritionTypeDto updateNutritionType(Long id, NutritionTypeDto nutritionType) {
        Optional<NutritionType> resultType = nutritionTypeRepository.findById(id);
        if(resultType.isPresent()){
            resultType.get().setType(nutritionType.getType());
            return modelMapper.map(nutritionTypeRepository.save(resultType.get()), NutritionTypeDto.class);

        } else {
            return null;
        }
    }

    @Override
    public NutritionTypeDto deleteNutritionType(Long id) {
        NutritionType deletedType = nutritionTypeRepository.findById(id).get();
        nutritionTypeRepository.deleteById(id);
        return modelMapper.map(deletedType, NutritionTypeDto.class );
    }
}
