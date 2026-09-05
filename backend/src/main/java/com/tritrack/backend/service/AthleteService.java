package com.tritrack.backend.service;

import com.tritrack.backend.athlete.Athlete;
import com.tritrack.backend.repository.AthleteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }
    public Athlete saveAthlete(Athlete athlete){
        Optional<Athlete> existingAthlete =
                athleteRepository.findByEmail(athlete.getEmail());

        if(existingAthlete.isPresent()){
            throw new IllegalArgumentException("Email is already registered");
        }
        return athleteRepository.save(athlete);
    }

    public List<Athlete> getAllAthletes(){
        return athleteRepository.findAll();
    }
}
