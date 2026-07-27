package com.tritrack.backend.repository;

import com.tritrack.backend.athlete.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}
