package fr.avramov.matchservice.exception;

public class MatchNotFoundException extends RuntimeException{

    public MatchNotFoundException(String message) {
        super(message);
    }
}
