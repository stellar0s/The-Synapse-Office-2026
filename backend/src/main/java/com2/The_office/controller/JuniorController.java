package com2.The_office.controller;


import com2.The_office.dto.JuniorDto;
import com2.The_office.service.JuniorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/juniors")
public class JuniorController {
    private JuniorService juniorService;

    @PostMapping
    public ResponseEntity<JuniorDto> createJunior(@RequestBody JuniorDto juniorDto) {
        JuniorDto savedJunior = juniorService.createJunior(juniorDto);
        return new ResponseEntity<>(savedJunior, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JuniorDto>> getAllJuniors() {
        List<JuniorDto>juniorDtos= juniorService.getAllJuniors();
        return ResponseEntity.ok(juniorDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<JuniorDto> updateJunior(@PathVariable("id") Long juniorId, @RequestBody JuniorDto updatedJuniorDto) {

        JuniorDto juniorDto= juniorService.updateJunior(juniorId, updatedJuniorDto);
        return  ResponseEntity.ok(juniorDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteJunior(@PathVariable("id") Long juniorId) {
        juniorService.deleteJunior(juniorId);
        return ResponseEntity.ok("junior deleted successfully!/");
    }
}
