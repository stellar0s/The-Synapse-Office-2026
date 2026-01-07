package com2.The_office.controller;

import com2.The_office.dto.FullStackDto;
import com2.The_office.service.FullStackService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/fullstack")
public class FullStackController {
    private FullStackService fullStackService;

    @PostMapping
    public ResponseEntity<FullStackDto> createFullStack(@RequestBody FullStackDto fullStackDto) {
        FullStackDto savedFullStack = fullStackService.createFullStack(fullStackDto);
        return new ResponseEntity<>(savedFullStack, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FullStackDto>> getAllFullStacks() {
        List<FullStackDto> fullStacks = fullStackService.getAllFullStacks();
        return ResponseEntity.ok(fullStacks);
    }

    @GetMapping("{id}")
    public ResponseEntity<FullStackDto> updateFullStack(@PathVariable("id") Long fullStackId,
                                                        @RequestBody FullStackDto updatedFullStack) {
        FullStackDto fullStackDto = fullStackService.updateFullStack(fullStackId, updatedFullStack);
        return ResponseEntity.ok(fullStackDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFullStack(@PathVariable("id") Long fullStackId) {
        fullStackService.deleteFullStack(fullStackId);
        return ResponseEntity.ok("FullStack deleted successfully!/");
    }
}
