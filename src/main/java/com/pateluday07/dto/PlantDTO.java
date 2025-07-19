package com.pateluday07.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlantDTO {

    private Long id;
    private String name;
    private String type;
    private String description;
    private String tip;

}
