package com.fooddiaryexample.fooddiaryexample.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer height;
    private Integer weight;
}
