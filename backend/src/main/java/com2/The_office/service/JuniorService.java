package com2.The_office.service;

import com2.The_office.dto.EmployeeDto;
import com2.The_office.dto.JuniorDto;

import java.util.List;

public interface JuniorService {
    JuniorDto createJunior(JuniorDto juniorDto);

    JuniorDto getJuniorById(Long id);

    List<JuniorDto> getAllJuniors();
    JuniorDto updateJunior(Long id,JuniorDto juniorDto);
    void deleteJunior(Long juniorId);
}
