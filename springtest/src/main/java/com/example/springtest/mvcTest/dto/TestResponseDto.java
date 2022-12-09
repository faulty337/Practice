package com.example.springtest.mvcTest.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TestResponseDto {
    private String name;
    private int age;
    private String email;
}
