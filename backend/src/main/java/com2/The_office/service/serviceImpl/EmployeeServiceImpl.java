package com2.The_office.service.serviceImpl;

import com2.The_office.dto.EmployeeDto;
import com2.The_office.entity.Employee;
import com2.The_office.exception.ResourceNotFoundException;
import com2.The_office.fileio.EmployeeFileWriter;
import com2.The_office.mapper.EmployeeMapper;
import com2.The_office.repository.EmployeeRepository;
import com2.The_office.service.EmployeeService;
import com2.The_office.controller.EmployeeSocketController; // <-- Import WebSocket controller
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeSocketController socketController; // Inject WebSocket

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        try {
            // DB save
            Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
            Employee savedEmployee = employeeRepository.save(employee);

            // File backup (File I/O)
            String data = "ID: " + savedEmployee.getId()
                    + ", Name: " + savedEmployee.getFirstName() + " " + savedEmployee.getLastName()
                    + ", Email: " + savedEmployee.getEmail()
                    + ", Role: " + savedEmployee.getEmployeeType();
            EmployeeFileWriter.writeEmployeeData(data);

            // WebSocket notification
            socketController.sendNewEmployee(EmployeeMapper.mapToEmployeeDto(savedEmployee));

            return EmployeeMapper.mapToEmployeeDto(savedEmployee);

        } catch (Exception e) {
            // DB fail হলে file-এ save + log
            EmployeeFileWriter.writeErrorLog("Database Save Failed: " + e.getMessage());
            EmployeeFileWriter.writeEmployeeData("FAILED_SAVE: " + employeeDto.toString());

            throw e; // rethrow for global exception handler
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with given id: " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not Found with given id: " + id)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setPhone(updatedEmployee.getPhone());
        employee.setSalary(updatedEmployee.getSalary());
        employee.setEmployeeType(updatedEmployee.getEmployeeType());
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setMainSkill(updatedEmployee.getMainSkill());

        Employee savedEmployee = employeeRepository.save(employee);

        // File backup update
        String data = "ID: " + savedEmployee.getId()
                + ", Name: " + savedEmployee.getFirstName() + " " + savedEmployee.getLastName()
                + ", Email: " + savedEmployee.getEmail()
                + ", Role: " + savedEmployee.getEmployeeType();
        EmployeeFileWriter.writeEmployeeData(data);

        // WebSocket notification
        socketController.sendNewEmployee(EmployeeMapper.mapToEmployeeDto(savedEmployee));

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not Found with given id: " + employeeId)
        );
        employeeRepository.deleteById(employeeId);

        // Optional: Log deletion in backup file
        EmployeeFileWriter.writeEmployeeData("Deleted Employee ID: " + employeeId);

        // Optional: WebSocket notification for deletion
        EmployeeDto deletedEmployeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        deletedEmployeeDto.setFirstName("[Deleted]");
        socketController.sendNewEmployee(deletedEmployeeDto);
    }
}
