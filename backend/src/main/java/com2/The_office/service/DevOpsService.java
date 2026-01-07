package com2.The_office.service;

import com2.The_office.dto.DevOpsDto;

import java.util.List;

public interface DevOpsService {
    DevOpsDto createDevOps(DevOpsDto devOpsDto);

    DevOpsDto getDevOpsById(Long id);

    List<DevOpsDto> getAllDevOps();
    DevOpsDto updateDevOps(Long id,DevOpsDto devOpsDto);
    void deleteDevOps(Long devOpsId);
}
