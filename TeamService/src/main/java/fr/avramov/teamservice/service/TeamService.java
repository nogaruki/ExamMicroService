package fr.avramov.teamservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import fr.avramov.teamservice.exception.TeamNotFoundException;
import fr.avramov.teamservice.model.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    List<Team> teams = Team.generateTeams();


    public Team getTeamById(Long id) {
        return teams.stream()
                .filter(team -> team.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TeamNotFoundException("Team not found with id: " + id));
    }

    public Team createTeam(Team team) {
        // Assurez-vous que l'ID de l'équipe n'est pas défini pour éviter les conflits
        if (team.getId() != null) {
            throw new IllegalArgumentException("Id must be null for a new Team");
        }

        // Générez un nouvel ID pour l'équipe (vous pouvez utiliser une logique personnalisée ici)
        Long newId = teams.stream()
                .map(Team::getId)
                .max(Long::compareTo)
                .orElse(0L) + 1;
        team.setId(newId);

        teams.add(team);
        return team;
    }

    public Team updateTeam(Long id, Team updatedTeam) {
        // Recherchez l'équipe existante par ID
        Team existingTeam = getTeamById(id);

        // Mettez à jour les attributs nécessaires ici
        existingTeam.setName(updatedTeam.getName());

        return existingTeam;
    }

    public void deleteTeam(Long id) {
        // Recherchez l'équipe existante par ID
        Team existingTeam = getTeamById(id);

        // Supprimez l'équipe de la liste
        teams.remove(existingTeam);
    }
}
