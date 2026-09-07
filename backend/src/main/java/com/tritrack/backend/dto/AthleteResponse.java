package com.tritrack.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AthleteResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double heightCm;
    private Double weightKg;
}
