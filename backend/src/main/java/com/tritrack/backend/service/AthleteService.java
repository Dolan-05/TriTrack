package com.tritrack.backend.service;

import com.tritrack.backend.athlete.Athlete;
import com.tritrack.backend.dto.AthleteResponse;
import com.tritrack.backend.dto.RegisterAthleteRequest;
import com.tritrack.backend.repository.AthleteRepository;
import com.tritrack.backend.exception.AthleteNotFoundException;
import com.tritrack.backend.exception.EmailAlreadyExistsException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;
    private final PasswordEncoder passwordEncoder;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }
    public AthleteResponse saveAthlete(RegisterAthleteRequest request){
        Optional<Athlete> existingAthlete =
                athleteRepository.findByEmail(request.getEmail());

        if(existingAthlete.isPresent()){
            throw new EmailAlreadyExistsException("Email is already registered");
        }
        Athlete athlete = new Athlete();

        athlete.setFirstName(request.getFirstName());
        athlete.setLastName(request.getLastName());
        athlete.setEmail(request.getEmail());

        Athlete savedAthlete = athleteRepository.save(athlete);

        AthleteResponse response = new AthleteResponse();

        response.setId(savedAthlete.getId());
        response.setFirstName(savedAthlete.getFirstName());
        response.setLastName(savedAthlete.getLastName());
        response.setEmail(savedAthlete.getEmail());
        response.setHeightCm(savedAthlete.getHeightCm());
        response.setWeightKg(savedAthlete.getWeightKg());

        return response;
    }

    public Athlete getAthleteById(Long id){
        Optional<Athlete> existingAthlete=
                athleteRepository.findById(id);

        if(existingAthlete.isEmpty()) {
            throw new AthleteNotFoundException("Athlete not found");
        }
        return existingAthlete.get();

    }

    public List<Athlete> getAllAthletes(){
        return athleteRepository.findAll();
    }
}
