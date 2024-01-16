package fr.avramov.statsservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TeamStats {

    Long id;
    Long teamId;
    Integer goals;
    Integer assists;
    Integer yellowCards;
    Integer redCards;
    Integer minutesPlayed;

    public TeamStats() {
    }

    public TeamStats(Long id, Long teamId, Integer goals, Integer assists, Integer yellowCards, Integer redCards, Integer minutesPlayed) {
        this.id = id;
        this.teamId = teamId;
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.minutesPlayed = minutesPlayed;
    }

    public Long getId() {
        return id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Integer getGoals() {
        return goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public Integer getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public void setMinutesPlayed(Integer minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public static List<TeamStats> generateTeamStats() {
        List<TeamStats> teamStatsList = new ArrayList<>();

        // Statistiques pour l'équipe 1
        TeamStats teamStats1 = new TeamStats();
        teamStats1.setId(1L);
        teamStats1.setTeamId(1L);
        teamStats1.setGoals(ThreadLocalRandom.current().nextInt(0, 50));
        teamStats1.setAssists(ThreadLocalRandom.current().nextInt(0, 30));
        teamStats1.setYellowCards(ThreadLocalRandom.current().nextInt(0, 20));
        teamStats1.setRedCards(ThreadLocalRandom.current().nextInt(0, 10));
        teamStats1.setMinutesPlayed(ThreadLocalRandom.current().nextInt(0, 9000)); // Minutes jouées (0 à 9000)

        // Statistiques pour l'équipe 2
        TeamStats teamStats2 = new TeamStats();
        teamStats2.setId(2L);
        teamStats2.setTeamId(2L);
        teamStats2.setGoals(ThreadLocalRandom.current().nextInt(0, 50));
        teamStats2.setAssists(ThreadLocalRandom.current().nextInt(0, 30));
        teamStats2.setYellowCards(ThreadLocalRandom.current().nextInt(0, 20));
        teamStats2.setRedCards(ThreadLocalRandom.current().nextInt(0, 10));
        teamStats2.setMinutesPlayed(ThreadLocalRandom.current().nextInt(0, 9000)); // Minutes jouées (0 à 9000)

        teamStatsList.add(teamStats1);
        teamStatsList.add(teamStats2);

        return teamStatsList;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", goals=" + goals +
                ", assists=" + assists +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                ", minutesPlayed=" + minutesPlayed +
                '}';
    }
}
