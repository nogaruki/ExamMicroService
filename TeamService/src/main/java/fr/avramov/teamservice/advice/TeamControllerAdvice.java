package fr.avramov.teamservice.advice;

import fr.avramov.teamservice.exception.TeamNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TeamControllerAdvice {

    @ExceptionHandler(TeamNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTeamNotFoundException(TeamNotFoundException e) {
        // Vous pouvez ajouter ici une logique supplémentaire, comme logger l'erreur.
    }
}
