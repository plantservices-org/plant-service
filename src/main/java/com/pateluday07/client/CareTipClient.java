package com.pateluday07.client;

import com.pateluday07.dto.CareTipRequestDTO;
import com.pateluday07.dto.CareTipResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "care-tip-service", path = "/api/v1/care-tips")
public interface CareTipClient {

    @GetMapping("/{plantId}")
    CareTipResponseDTO getCareTipByPlantId(@PathVariable("plantId") Long plantId);

    @PostMapping
    CareTipResponseDTO saveCareTip(@RequestBody CareTipRequestDTO careTipRequestDTO);
}
