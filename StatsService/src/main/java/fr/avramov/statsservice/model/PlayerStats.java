package fr.avramov.statsservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerStats {

    Long id;
    Long playerId;
    Integer goals;

    Integer assists;

    Integer yellowCards;

    Integer redCards;

    Integer minutesPlayed;

    public PlayerStats() {
    }

    public PlayerStats(Long id, Long playerId, Integer goals, Integer assists, Integer yellowCards, Integer redCards, Integer minutesPlayed) {
        this.id = id;
        this.playerId = playerId;
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.minutesPlayed = minutesPlayed;
    }

    public Long getId() {
        return id;
    }

    public Long getPlayerId() {
        return playerId;
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

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
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

    public static List<PlayerStats> generatePlayerStats() {
        List<PlayerStats> playerStatsList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            PlayerStats playerStats = new PlayerStats();
            playerStats.setId((long) i);
            playerStats.setPlayerId((long) i);
            playerStats.setGoals(ThreadLocalRandom.current().nextInt(0, 20));
            playerStats.setAssists(ThreadLocalRandom.current().nextInt(0, 15));
            playerStats.setYellowCards(ThreadLocalRandom.current().nextInt(0, 10));
            playerStats.setRedCards(ThreadLocalRandom.current().nextInt(0, 5));
            playerStats.setMinutesPlayed(ThreadLocalRandom.current().nextInt(0, 1800)); // Minutes jouées (0 à 1800)

            playerStatsList.add(playerStats);
        }

        return playerStatsList;

    }
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", goals=" + goals +
                ", assists=" + assists +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                ", minutesPlayed=" + minutesPlayed +
                '}';
    }
}
