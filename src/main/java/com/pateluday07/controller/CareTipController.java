package com.pateluday07.controller;

import com.pateluday07.dto.CareTipRequestDTO;
import com.pateluday07.dto.CareTipResponseDTO;
import com.pateluday07.service.CareTipService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/plants")
@AllArgsConstructor
public class CareTipController {

    private final CareTipService careTipService;

    @PostMapping("/care-tips")
    public ResponseEntity<CareTipResponseDTO> saveCareTip(@RequestBody CareTipRequestDTO careTipRequest) {
        return ResponseEntity.ok(careTipService.saveCareTip(careTipRequest));
    }

}
