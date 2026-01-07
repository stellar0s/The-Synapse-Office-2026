package com2.The_office.service.serviceImpl;

import com2.The_office.dto.DevOpsDto;
import com2.The_office.entity.DevOps;
import com2.The_office.exception.ResourceNotFoundException;
import com2.The_office.mapper.DevOpsMapper;
import com2.The_office.service.DevOpsService;
import lombok.AllArgsConstructor;
import com2.The_office.repository.DevOpsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DevOpsImpl implements DevOpsService {
    private DevOpsRepository devOpsRepository;

    @Override
    public DevOpsDto createDevOps(DevOpsDto devOpsDto) {
        DevOps devOps = DevOpsMapper.mapToDevOps(devOpsDto);
        DevOps savedDevOps = devOpsRepository.save(devOps);
        return DevOpsMapper.mapToDevOpsDto(savedDevOps);
    }

    @Override
    public DevOpsDto getDevOpsById(Long id) {
        DevOps devOps= devOpsRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("DevOps Not Found with give id: "+id));
        return DevOpsMapper.mapToDevOpsDto(devOps);
    }

    @Override
    public List<DevOpsDto> getAllDevOps() {
        List<DevOps> devOps= devOpsRepository.findAll();
        return devOps.stream().map((devOp -> DevOpsMapper.mapToDevOpsDto(devOp)))
                .collect(Collectors.toList());
    }

    @Override
    public DevOpsDto updateDevOps(Long id, DevOpsDto updatedDevOps) {
        DevOps devOps=  devOpsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("DevOps Not Found with give id: "+id)
        );
        devOps.setFirstName(updatedDevOps.getFirstName());
        devOps.setLastName(updatedDevOps.getLastName());
        devOps.setEmail(updatedDevOps.getEmail());
        devOps.setPhone(updatedDevOps.getPhone());
        devOps.setSalary(updatedDevOps.getSalary());
        devOps.setEmployeeType(updatedDevOps.getEmployeeType());
        devOps.setDepartment(updatedDevOps.getDepartment());
        devOps.setMainSkill(updatedDevOps.getMainSkill());

        DevOps savedDevOps = devOpsRepository.save(devOps);
        return  DevOpsMapper.mapToDevOpsDto(savedDevOps);
    }

    @Override
    public void deleteDevOps(Long devOpsId) {
        DevOps devOps = devOpsRepository.findById(devOpsId).orElseThrow(
                () -> new ResourceNotFoundException("DevOps Not Found with give id: " + devOpsId)
        );
    }
}
