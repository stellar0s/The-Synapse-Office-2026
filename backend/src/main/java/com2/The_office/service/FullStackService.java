package com2.The_office.service;

import com2.The_office.dto.FullStackDto;
import com2.The_office.entity.FullStack;

import java.util.List;

public interface FullStackService {
    FullStackDto createFullStack(FullStackDto fullStackDto);

    FullStackDto getFullStackById(Long id);

    List<FullStackDto> getAllFullStacks();
    FullStackDto updateFullStack(Long id, FullStackDto updatedFullStack);
    void deleteFullStack(Long fullStackId);
}
