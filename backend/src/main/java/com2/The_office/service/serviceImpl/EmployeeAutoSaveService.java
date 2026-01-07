package com2.The_office.service.serviceImpl;

import com2.The_office.dto.EmployeeDto;
import com2.The_office.entity.Employee;
import com2.The_office.fileio.EmployeeFileWriter;
import com2.The_office.mapper.EmployeeMapper;
import com2.The_office.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeAutoSaveService {

    private final EmployeeRepository employeeRepository;

    // Runs every 5 minutes (300000 ms)
    @Scheduled(fixedRate = 300000)
    public void autoSaveEmployees() {
        try {
            List<Employee> employees = employeeRepository.findAll();
            for (Employee emp : employees) {
                EmployeeDto dto = EmployeeMapper.mapToEmployeeDto(emp);
                String data = "AUTO_SAVE → ID: " + dto.getId()
                        + ", Name: " + dto.getFirstName() + " " + dto.getLastName()
                        + ", Email: " + dto.getEmail()
                        + ", Role: " + dto.getEmployeeType();
                EmployeeFileWriter.writeEmployeeData(data);
            }
            System.out.println("✅ Auto-saved " + employees.size() + " employees to backup file.");
        } catch (Exception e) {
            EmployeeFileWriter.writeErrorLog("Auto-Save Failed: " + e.getMessage());
        }
    }
}
