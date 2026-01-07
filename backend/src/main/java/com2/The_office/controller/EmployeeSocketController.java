package com2.The_office.controller;

import com2.The_office.dto.EmployeeDto;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public EmployeeSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Call this method when a new employee is added
    public void sendNewEmployee(EmployeeDto employeeDto) {
        messagingTemplate.convertAndSend("/topic/employees", employeeDto);
    }
}
