package com2.The_office.service.serviceImpl;

import com2.The_office.dto.BackEndDto;
import com2.The_office.entity.BackEnd;
import com2.The_office.exception.ResourceNotFoundException;
import com2.The_office.mapper.BackEndMapper;
import com2.The_office.repository.BackEndRepository;
import com2.The_office.service.BackEndService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BackEndServiceImpl implements BackEndService {
    private BackEndRepository backEndRepository;

    @Override
    public BackEndDto createBackEnd(BackEndDto backEndDto) {
        BackEnd backEnd = BackEndMapper.mapToBackEnd(backEndDto);
        BackEnd savedBackEnd = backEndRepository.save(backEnd);
        return BackEndMapper.mapToBackEndDto(savedBackEnd);
    }

    @Override
    public BackEndDto getBackEndById(Long id) {
        BackEnd backEnd= backEndRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("BackEnd Not Found with give id: "+id));
        return BackEndMapper.mapToBackEndDto(backEnd);
    }

    @Override
    public List<BackEndDto> getAllBackEnds() {
        List<BackEnd>  backEnds= backEndRepository.findAll();
        return backEnds.stream().map((backEnd -> BackEndMapper.mapToBackEndDto(backEnd)))
                .collect(Collectors.toList());
    }

    @Override
    public BackEndDto updateBackEnd(Long id, BackEndDto updatedBackEnd) {
        BackEnd backEnd=  backEndRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("BackEnd Not Found with give id: "+id)
        );
        backEnd.setFirstName(updatedBackEnd.getFirstName());
        backEnd.setLastName(updatedBackEnd.getLastName());
        backEnd.setEmail(updatedBackEnd.getEmail());
        backEnd.setPhone(updatedBackEnd.getPhone());
        backEnd.setSalary(updatedBackEnd.getSalary());
        backEnd.setEmployeeType(updatedBackEnd.getEmployeeType());
        backEnd.setDepartment(updatedBackEnd.getDepartment());
        backEnd.setMainSkill(updatedBackEnd.getMainSkill());

        BackEnd savedBackEnd = backEndRepository.save(backEnd);
        return  BackEndMapper.mapToBackEndDto(savedBackEnd);
    }

    @Override
    public void deleteBackEnd(Long backEndId) {
        backEndRepository.deleteById(backEndId);
    }
}
