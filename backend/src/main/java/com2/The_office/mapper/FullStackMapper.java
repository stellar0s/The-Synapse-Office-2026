package com2.The_office.mapper;

import com2.The_office.dto.FullStackDto;
import com2.The_office.entity.FullStack;

public class FullStackMapper {
    public static FullStackDto mapToFullStackDto(FullStack fullStack) {
        return new FullStackDto(
                fullStack.getId(),
                fullStack.getFirstName(),
                fullStack.getLastName(),
                fullStack.getEmail(),
                fullStack.getPhone(),
                fullStack.getSalary(),
                fullStack.getEmployeeType(),
                fullStack.getDepartment(),
                fullStack.getMainSkill()
        );
    }

    public static FullStack mapToFullStack(FullStackDto fullStackDto) {
        return new FullStack(fullStackDto.getId(),
                fullStackDto.getFirstName(),
                fullStackDto.getLastName(),
                fullStackDto.getEmail(),
                fullStackDto.getPhone(),
                fullStackDto.getSalary(),
                fullStackDto.getEmployeeType(),
                fullStackDto.getDepartment(),
                fullStackDto.getMainSkill()
        );
    }
}
