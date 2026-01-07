package com2.The_office.controller;

import com2.The_office.dto.BackEndDto;
import com2.The_office.service.BackEndService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/backEnds")
public class BackEndController {
    private BackEndService backEndService;

    @PostMapping
    public ResponseEntity<BackEndDto> createBackEnd(@RequestBody BackEndDto backEndDto) {
        BackEndDto savedBackEnd = backEndService.createBackEnd(backEndDto);
        return new ResponseEntity<>(savedBackEnd, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BackEndDto>> getAllBackEnds() {
        List<BackEndDto> backEnds= backEndService.getAllBackEnds();
        return ResponseEntity.ok(backEnds);
    }

    @PutMapping("{id}")
    public ResponseEntity<BackEndDto> updateBackEnd(@PathVariable("id") Long backEndId,
                                                  @RequestBody BackEndDto updatedBackEnd) {
        BackEndDto backEndDto= backEndService.updateBackEnd(backEndId, updatedBackEnd);
        return  ResponseEntity.ok(backEndDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBackEnd(@PathVariable("id") Long backEndId) {
        backEndService.deleteBackEnd(backEndId);
        return ResponseEntity.ok("BackEnd deleted successfully!/");
    }
}
