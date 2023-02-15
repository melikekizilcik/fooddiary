package com.fooddiaryexample.fooddiaryexample.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="nutrition",schema = "public")
public class Nutrition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "nutrition_name")
    private String nutritionName;
    @Column(name = "kcal")
    private Double kcal;
    @Column(name = "protein")
    private Double protein;
    @Column(name = "fat")
    private Double fat;
    @Column(name = "carbonhydrate")
    private Double carbonhydrate;
    @OneToOne
    @JoinColumn(name = "nutrition_type")
    private NutritionType nutritionType;
}
