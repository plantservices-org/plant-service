package com.pateluday07.service;

import com.pateluday07.dto.CareTipRequestDTO;
import com.pateluday07.dto.CareTipResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CareTipServiceImpl implements CareTipService {

    private final CareTipService careTipService;

    @Override
    public CareTipResponseDTO saveCareTip(CareTipRequestDTO careTipRequestDTO) {
        // need to call careTipService to save the care tip
        return null;
    }

}
