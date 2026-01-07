package com2.The_office.mapper;

import com2.The_office.dto.DevOpsDto;
import com2.The_office.entity.DevOps;

public class DevOpsMapper {
    public static DevOpsDto mapToDevOpsDto(DevOps devOps) {
        return new DevOpsDto(
                devOps.getId(),
                devOps.getFirstName(),
                devOps.getLastName(),
                devOps.getEmail(),
                devOps.getPhone(),
                devOps.getSalary(),
                devOps.getEmployeeType(),
                devOps.getDepartment(),
                devOps.getMainSkill()
        );
    }

    public static DevOps mapToDevOps(DevOpsDto dto) {
        return new DevOps(
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
