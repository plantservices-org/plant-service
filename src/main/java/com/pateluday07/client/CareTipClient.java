package com.pateluday07.client;

import com.pateluday07.dto.CareTipDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "care-tip-service", url = "${care-tip-service.url}", path = "/api/v1/care-tips")
public interface CareTipClient {

    @GetMapping("/{plantId}")
    CareTipDTO getCareTipByPlantId(@PathVariable("plantId") Long plantId);

    @PostMapping
    CareTipDTO saveCareTip(@RequestBody CareTipDTO careTipDTO);
}
