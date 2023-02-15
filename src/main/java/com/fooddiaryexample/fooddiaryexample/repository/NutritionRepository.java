package com.fooddiaryexample.fooddiaryexample.repository;

import com.fooddiaryexample.fooddiaryexample.model.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionRepository extends JpaRepository<Nutrition, Long> {
}
