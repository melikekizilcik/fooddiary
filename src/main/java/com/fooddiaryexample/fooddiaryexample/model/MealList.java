package com.fooddiaryexample.fooddiaryexample.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="meal-list",schema = "public")
public class MealList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meal")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "nutrition")
    private Nutrition nutrition;

}
