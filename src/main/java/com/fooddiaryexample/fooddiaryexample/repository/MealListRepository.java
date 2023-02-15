package com.fooddiaryexample.fooddiaryexample.repository;

import com.fooddiaryexample.fooddiaryexample.model.MealList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealListRepository extends JpaRepository<MealList, Long> {
}
