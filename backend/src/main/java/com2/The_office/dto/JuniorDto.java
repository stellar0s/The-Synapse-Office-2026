package com2.The_office.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JuniorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Double salary;
    private String employeeType;
    private String department;
    private String mainSkill;
}
