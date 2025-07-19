package com.pateluday07.service;

import com.pateluday07.dto.CareTipRequestDTO;
import com.pateluday07.dto.CareTipResponseDTO;

public interface CareTipService {

    CareTipResponseDTO saveCareTip(CareTipRequestDTO careTipRequestDTO);

}
