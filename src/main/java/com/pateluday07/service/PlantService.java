package com.pateluday07.service;

import com.pateluday07.dto.PlantDTO;
import com.pateluday07.dto.PlantSummaryDTO;

import java.util.List;

public interface PlantService {

    List<PlantSummaryDTO> getAllPlants();

    PlantDTO getPlantById(Long id);

}
