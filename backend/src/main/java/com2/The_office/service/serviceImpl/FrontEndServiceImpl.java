package com2.The_office.service.serviceImpl;

import com2.The_office.dto.FrontEndDto;
import com2.The_office.entity.FrontEnd;
import com2.The_office.exception.ResourceNotFoundException;
import com2.The_office.mapper.FrontEndMapper;
import com2.The_office.repository.FrontEndRepository;
import com2.The_office.service.FrontEndService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FrontEndServiceImpl implements FrontEndService {
    private FrontEndRepository frontEndRepository;

    @Override
    public FrontEndDto createFrontEnd(FrontEndDto frontEndDto) {
        FrontEnd frontEnd = FrontEndMapper.mapToFrontEnd(frontEndDto);
        FrontEnd savedFrontEnd = frontEndRepository.save(frontEnd);
        return FrontEndMapper.mapToFrontEndDto(savedFrontEnd);
    }

    @Override
    public FrontEndDto getFrontEndById(Long id) {
        FrontEnd frontEnd= frontEndRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("FrontEnd Not Found with give id: "+id));
        return FrontEndMapper.mapToFrontEndDto(frontEnd);
    }

    @Override
    public List<FrontEndDto> getAllFrontEnds() {
        List<FrontEnd>  frontEnds= frontEndRepository.findAll();
        return frontEnds.stream().map((frontEnd -> FrontEndMapper.mapToFrontEndDto(frontEnd)))
                .collect(Collectors.toList());
    }

    @Override
    public FrontEndDto updateFrontEnd(Long id, FrontEndDto updatedFrontEnd) {
        FrontEnd frontEnd=  frontEndRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("FrontEnd Not Found with give id: "+id)
        );
        frontEnd.setFirstName(updatedFrontEnd.getFirstName());
        frontEnd.setLastName(updatedFrontEnd.getLastName());
        frontEnd.setEmail(updatedFrontEnd.getEmail());
        frontEnd.setPhone(updatedFrontEnd.getPhone());
        frontEnd.setSalary(updatedFrontEnd.getSalary());
        frontEnd.setEmployeeType(updatedFrontEnd.getEmployeeType());
        frontEnd.setDepartment(updatedFrontEnd.getDepartment());
        frontEnd.setMainSkill(updatedFrontEnd.getMainSkill());

        FrontEnd savedFrontEnd = frontEndRepository.save(frontEnd);
        return  FrontEndMapper.mapToFrontEndDto(savedFrontEnd);
    }

    @Override
    public void deleteFrontEnd(Long frontEndId) {
        FrontEnd frontEnd=  frontEndRepository.findById(frontEndId).orElseThrow(
                () -> new ResourceNotFoundException("FrontEnd Not Found with give id: "+frontEndId)
        );
        frontEndRepository.delete(frontEnd);
    }
}
