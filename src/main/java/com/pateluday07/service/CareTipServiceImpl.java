package com.pateluday07.service;

import com.pateluday07.client.CareTipClient;
import com.pateluday07.dto.CareTipDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CareTipServiceImpl implements CareTipService {

    private final CareTipClient careTipClient;

    @Override
    public CareTipDTO saveCareTip(CareTipDTO careTipDTO) {
        if (careTipDTO.getPlantId() == null || careTipDTO.getTip() == null || careTipDTO.getTip().isEmpty()) {
            throw new IllegalArgumentException("Plant ID and tip cannot be null or empty");
        }
        try {
            return careTipClient.saveCareTip(careTipDTO);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save care tip: " + e.getMessage(), e);
        }
    }

}
