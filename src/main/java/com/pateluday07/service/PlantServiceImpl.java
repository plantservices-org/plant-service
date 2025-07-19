package com.pateluday07.service;

import com.pateluday07.client.CareTipClient;
import com.pateluday07.dto.PlantDTO;
import com.pateluday07.dto.PlantSummaryDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final CareTipClient careTipClient;

    private static final Map<Long, PlantDTO> PLANT_DUMMY_DB = Map.of(
            1L, new PlantDTO(1L, "Rose", "Flowering", "A beautiful red flower", ""),
            2L, new PlantDTO(2L, "Cactus", "Succulent", "A hardy desert plant", "")
    );

    @Override
    public List<PlantSummaryDTO> getAllPlants() {
        return PLANT_DUMMY_DB
                .values()
                .stream()
                .map(plant -> new PlantSummaryDTO(plant.getId(), plant.getName()))
                .toList();
    }

    @Override
    public PlantDTO getPlantById(Long id) {
        if (!PLANT_DUMMY_DB.containsKey(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found with ID: " + id);
        PlantDTO plant = PLANT_DUMMY_DB.get(id);
        try {
            var careTip = careTipClient.getCareTipByPlantId(id);
            plant.setTip(careTip.getTip());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to fetch care tip for plant ID: " + id, e);
        }
        return plant;
    }

}
