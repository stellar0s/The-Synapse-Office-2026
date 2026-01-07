package com2.The_office.mapper;

import com2.The_office.dto.BackEndDto;
import com2.The_office.entity.BackEnd;

public class BackEndMapper {
    public static BackEndDto mapToBackEndDto(BackEnd emp) {
        return new BackEndDto(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail(),
                emp.getPhone(),
                emp.getSalary(),
                emp.getEmployeeType(),
                emp.getDepartment(),
                emp.getMainSkill()
        );
    }

    public static BackEnd mapToBackEnd(BackEndDto dto) {
        return new BackEnd(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getSalary(),
                dto.getEmployeeType(),
                dto.getDepartment(),
                dto.getMainSkill()
        );
    }
}
