package fr.avramov.playerservice.exception;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String message) {
        super(message);
    }
}
