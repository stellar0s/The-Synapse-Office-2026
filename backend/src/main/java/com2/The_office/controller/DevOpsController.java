package com2.The_office.controller;

import com2.The_office.dto.DevOpsDto;
import com2.The_office.service.DevOpsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/devops")
public class DevOpsController {
    private DevOpsService devOpsService;

    @PostMapping
    public ResponseEntity<DevOpsDto> createDevOps(@RequestBody DevOpsDto devOpsDto) {
        DevOpsDto savedDevOps = devOpsService.createDevOps(devOpsDto);
        return new ResponseEntity<>(savedDevOps, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DevOpsDto>> getAllDevOps() {
        List<DevOpsDto> devOps= devOpsService.getAllDevOps();
        return ResponseEntity.ok(devOps);
    }

    @PutMapping("{id}")
    public ResponseEntity<DevOpsDto> updateDevOps(@PathVariable("id") Long devOpsId,
                                                  @RequestBody DevOpsDto updatedDevOps) {
        DevOpsDto devOpsDto= devOpsService.updateDevOps(devOpsId, updatedDevOps);
        return  ResponseEntity.ok(devOpsDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDevOps(@PathVariable("id") Long devOpsId) {
        devOpsService.deleteDevOps(devOpsId);
        return ResponseEntity.ok("DevOps deleted successfully!/");
    }
}
