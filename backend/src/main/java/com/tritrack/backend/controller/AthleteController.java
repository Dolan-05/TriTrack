package com.tritrack.backend.controller;

import com.tritrack.backend.athlete.Athlete;
import com.tritrack.backend.service.AthleteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/athletes")
public class AthleteController {
    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService){
        this.athleteService = athleteService;
    }

    @PostMapping
    public Athlete createAthlete(@RequestBody Athlete athlete){
        return athleteService.saveAthlete(athlete);
    }
    @GetMapping
    public List<Athlete> getAthletes(){
        return athleteService.getAllAthletes();
    }

}
