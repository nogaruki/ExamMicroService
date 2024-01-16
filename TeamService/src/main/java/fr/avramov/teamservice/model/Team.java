package fr.avramov.teamservice.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private Long id;

    private String name;

    private PlayerDTO[] playerDTOS; // Liste des noms des joueurs

    // Constructeurs
    public Team() {
    }

    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerDTO[] getPlayers() {
        return playerDTOS;
    }

    public void setPlayers(PlayerDTO[] playerDTOS) {
        this.playerDTOS = playerDTOS;
    }

    @Override
    public String toString() {
        return "{" +
            " id:'" + getId() + "'" +
            ", name:'" + getName() + "'" +
            ", players;'" + getPlayers() + "'" +
            "}";
    }

    public static List<Team> generateTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team(1L, "PSG"));
        teams.add(new Team(2L, "OM"));
        return teams;
    }
}
