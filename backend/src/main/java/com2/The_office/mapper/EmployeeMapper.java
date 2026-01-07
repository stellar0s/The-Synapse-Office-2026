package com2.The_office.mapper;

import com2.The_office.dto.EmployeeDto;
import com2.The_office.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee emp) {
        return new EmployeeDto(
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

    public static Employee mapToEmployee(EmployeeDto dto) {
        return new Employee(
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
