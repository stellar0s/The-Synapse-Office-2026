package com2.The_office.service.serviceImpl;

import com2.The_office.dto.FullStackDto;
import com2.The_office.entity.FullStack;
import com2.The_office.exception.ResourceNotFoundException;
import com2.The_office.repository.FullStackRepository;
import com2.The_office.service.FullStackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com2.The_office.mapper.FullStackMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FullStackServiceImpl implements FullStackService {
    private FullStackRepository fullStackRepository;

    @Override
    public FullStackDto createFullStack(FullStackDto fullStackDto) {
        FullStack fullStack = FullStackMapper.mapToFullStack(fullStackDto);
        FullStack savedFullStack = fullStackRepository.save(fullStack);
        return FullStackMapper.mapToFullStackDto(savedFullStack);
    }

    @Override
    public FullStackDto getFullStackById(Long id) {
        FullStack fullStack= fullStackRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("FullStack Not Found with give id: "+id));
        return FullStackMapper.mapToFullStackDto(fullStack);
    }

    @Override
    public List<FullStackDto> getAllFullStacks() {
        List<FullStack>  fullStacks= fullStackRepository.findAll();
        return fullStacks.stream().map((fullStack -> FullStackMapper.mapToFullStackDto(fullStack)))
                .collect(Collectors.toList());
    }

    @Override
    public FullStackDto updateFullStack(Long id, FullStackDto updatedFullStack) {
        FullStack fullStack=  fullStackRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("FullStack Not Found with give id: "+id)
        );
        fullStack.setFirstName(updatedFullStack.getFirstName());
        fullStack.setLastName(updatedFullStack.getLastName());
        fullStack.setEmail(updatedFullStack.getEmail());
        fullStack.setPhone(updatedFullStack.getPhone());
        fullStack.setSalary(updatedFullStack.getSalary());
        fullStack.setEmployeeType(updatedFullStack.getEmployeeType());
        fullStack.setDepartment(updatedFullStack.getDepartment());
        fullStack.setMainSkill(updatedFullStack.getMainSkill());

        FullStack savedFullStack = fullStackRepository.save(fullStack);
        return  FullStackMapper.mapToFullStackDto(savedFullStack);
    }

    @Override
    public void deleteFullStack(Long fullStackId) {
        FullStack fullStack = fullStackRepository.findById(fullStackId).orElseThrow(
                () -> new ResourceNotFoundException("FullStack Not Found with give id: " + fullStackId)
        );
        fullStackRepository.delete(fullStack);
    }
}
