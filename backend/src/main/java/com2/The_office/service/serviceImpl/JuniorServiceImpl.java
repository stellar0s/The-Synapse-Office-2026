package com2.The_office.service.serviceImpl;

import com2.The_office.dto.JuniorDto;
import com2.The_office.entity.Employee;
import com2.The_office.entity.JuniorDev;
import com2.The_office.exception.ResourceNotFoundException;
import com2.The_office.mapper.EmployeeMapper;
import com2.The_office.mapper.JuniorMapper;
import com2.The_office.repository.JuniorRepository;
import com2.The_office.service.JuniorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JuniorServiceImpl implements JuniorService {
    private JuniorRepository juniorRepository;

    @Override
    public JuniorDto createJunior(JuniorDto juniorDto) {
        JuniorDev juniorDev = JuniorMapper.mapToJuniorDev(juniorDto);
        JuniorDev savedJunior = juniorRepository.save(juniorDev);
        return JuniorMapper.mapToJuniorDto(savedJunior);
    }

    @Override
    public JuniorDto getJuniorById(Long id) {
        JuniorDev juniorDev= juniorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("JuniorDev Not Found with give id: "+id));
        return JuniorMapper.mapToJuniorDto(juniorDev);
    }

    @Override
    public List<JuniorDto> getAllJuniors() {
        List<JuniorDev>  juniorDevs= juniorRepository.findAll();
        return juniorDevs.stream().map((juniorDev -> JuniorMapper.mapToJuniorDto(juniorDev)))
                .collect(Collectors.toList());
    }

    @Override
    public JuniorDto updateJunior(Long id, JuniorDto updatedJunior) {
        JuniorDev juniorDev=  juniorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("JuniorDev Not Found with give id: "+id)
        );
        juniorDev.setFirstName(updatedJunior.getFirstName());
        juniorDev.setLastName(updatedJunior.getLastName());
        juniorDev.setEmail(updatedJunior.getEmail());
        juniorDev.setPhone(updatedJunior.getPhone());
        juniorDev.setSalary(updatedJunior.getSalary());
        juniorDev.setEmployeeType(updatedJunior.getEmployeeType());
        juniorDev.setDepartment(updatedJunior.getDepartment());
        juniorDev.setMainSkill(updatedJunior.getMainSkill());

        JuniorDev savedJunior = juniorRepository.save(juniorDev);
        return  JuniorMapper.mapToJuniorDto(savedJunior);
    }

    @Override
    public void deleteJunior(Long juniorId) {
        JuniorDev juniorDev=  juniorRepository.findById(juniorId).orElseThrow(
                () -> new ResourceNotFoundException("JuniorDev Not Found with give id: "+juniorId)
        );
        juniorRepository.deleteById(juniorId);
    }
}
