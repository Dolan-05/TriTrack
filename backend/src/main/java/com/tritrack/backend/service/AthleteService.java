package com.tritrack.backend.service;

import com.tritrack.backend.athlete.Athlete;
import com.tritrack.backend.repository.AthleteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }
    public Athlete saveAthlete(Athlete athlete){
        return athleteRepository.save(athlete);
    }

    public List<Athlete> getAllAthletes(){
        return athleteRepository.findAll();
    }
}
