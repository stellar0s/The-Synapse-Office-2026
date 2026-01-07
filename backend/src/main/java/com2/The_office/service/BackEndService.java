package com2.The_office.service;

import com2.The_office.dto.BackEndDto;

import java.util.List;

public interface BackEndService {
    BackEndDto createBackEnd(BackEndDto backEndDto);

    BackEndDto getBackEndById(Long id);

    List<BackEndDto> getAllBackEnds();
    BackEndDto updateBackEnd(Long id, BackEndDto backEndDto);
    void deleteBackEnd(Long backEndId);
}
