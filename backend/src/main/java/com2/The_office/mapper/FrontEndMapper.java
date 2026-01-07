package com2.The_office.mapper;

import com2.The_office.dto.FrontEndDto;
import com2.The_office.entity.FrontEnd;

public class FrontEndMapper {
    public static FrontEndDto mapToFrontEndDto(FrontEnd emp) {
        return new FrontEndDto(
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

    public static FrontEnd mapToFrontEnd(FrontEndDto dto) {
        return new FrontEnd(
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
