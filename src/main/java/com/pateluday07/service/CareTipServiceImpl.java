package com.pateluday07.service;

import com.pateluday07.client.CareTipClient;
import com.pateluday07.dto.CareTipDTO;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
            if (!PlantServiceImpl.getPlantDummyDb().containsKey(careTipDTO.getPlantId())) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found with ID: " + careTipDTO.getPlantId());
            }
            return careTipClient.saveCareTip(careTipDTO);
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.status()), e.getMessage());
        }
    }

}
