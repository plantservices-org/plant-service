package com.pateluday07.service;

import com.pateluday07.client.CareTipClient;
import com.pateluday07.dto.CareTipRequestDTO;
import com.pateluday07.dto.CareTipResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CareTipServiceImpl implements CareTipService {

    private final CareTipClient careTipClient;

    @Override
    public CareTipResponseDTO saveCareTip(CareTipRequestDTO careTipRequestDTO) {
        if (careTipRequestDTO.getPlantId() == null || careTipRequestDTO.getTip() == null || careTipRequestDTO.getTip().isEmpty()) {
            throw new IllegalArgumentException("Plant ID and tip cannot be null or empty");
        }
        try {
            return careTipClient.saveCareTip(careTipRequestDTO);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save care tip: " + e.getMessage(), e);
        }
    }

}
