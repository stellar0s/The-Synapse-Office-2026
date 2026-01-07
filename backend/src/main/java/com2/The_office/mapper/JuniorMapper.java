package com2.The_office.mapper;

import com2.The_office.dto.JuniorDto;
import com2.The_office.entity.JuniorDev;

public class JuniorMapper {

    public static JuniorDto mapToJuniorDto(JuniorDev juniorDev){
        return new JuniorDto(
                juniorDev.getId(),
                juniorDev.getFirstName(),
                juniorDev.getLastName(),
                juniorDev.getEmail(),
                juniorDev.getPhone(),
                juniorDev.getSalary(),
                juniorDev.getEmployeeType(),
                juniorDev.getDepartment(),
                juniorDev.getMainSkill()
        );
    }

    public static JuniorDev mapToJuniorDev(JuniorDto juniorDto){
        return new JuniorDev(
                juniorDto.getId(),
                juniorDto.getFirstName(),
                juniorDto.getLastName(),
                juniorDto.getEmail(),
                juniorDto.getPhone(),
                juniorDto.getSalary(),
                juniorDto.getEmployeeType(),
                juniorDto.getDepartment(),
                juniorDto.getMainSkill()
        );
    }
}
