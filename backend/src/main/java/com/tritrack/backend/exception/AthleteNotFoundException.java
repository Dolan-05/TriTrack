package com.tritrack.backend.exception;;

public class AthleteNotFoundException extends RuntimeException{
    public AthleteNotFoundException(String message){
        super(message);
    }
}
