package com2.The_office.controller;

import com2.The_office.dto.FrontEndDto;
import com2.The_office.service.FrontEndService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/frontend")
public class FrontEndController {
    private FrontEndService frontEndService;

    @PostMapping
    public ResponseEntity<FrontEndDto> createFrontEnd(@RequestBody FrontEndDto frontEndDto) {
        FrontEndDto savedFrontEnd = frontEndService.createFrontEnd(frontEndDto);
        return new ResponseEntity<>(savedFrontEnd, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FrontEndDto>> getAllFrontEnds() {
        List<FrontEndDto>frontEnds= frontEndService.getAllFrontEnds();
        return ResponseEntity.ok(frontEnds);
    }

    @PutMapping("{id}")
    public ResponseEntity<FrontEndDto> updateFrontEnd(@PathVariable("id") Long frontEndId,
                                                      @RequestBody FrontEndDto updatedFrontEnd) {
        FrontEndDto frontEndDto= frontEndService.updateFrontEnd(frontEndId, updatedFrontEnd);
        return  ResponseEntity.ok(frontEndDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFrontEnd(@PathVariable("id") Long frontEndId) {
        frontEndService.deleteFrontEnd(frontEndId);
        return ResponseEntity.ok("FrontEnd deleted successfully!/");
    }
}
