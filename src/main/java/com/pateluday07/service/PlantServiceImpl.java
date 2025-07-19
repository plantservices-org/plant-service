package com.pateluday07.service;

import com.pateluday07.dto.PlantDTO;
import com.pateluday07.dto.PlantSummaryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
public class PlantServiceImpl implements PlantService {

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
        // need to call care tip service to get care tips for the plant
        plant.setTip("");
        return plant;
    }

}
