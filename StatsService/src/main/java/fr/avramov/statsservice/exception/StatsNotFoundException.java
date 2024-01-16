package fr.avramov.statsservice.exception;

public class StatsNotFoundException extends RuntimeException {

    public StatsNotFoundException(String message) {
        super(message);
    }
}
