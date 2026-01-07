package com2.The_office.service;

import com2.The_office.dto.FrontEndDto;

import java.util.List;

public interface FrontEndService {
    FrontEndDto createFrontEnd(FrontEndDto frontEndDto);

    FrontEndDto getFrontEndById(Long id);

    List<FrontEndDto> getAllFrontEnds();
    FrontEndDto updateFrontEnd(Long id, FrontEndDto frontEndDto);
    void deleteFrontEnd(Long frontEndId);
}
