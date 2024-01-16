package fr.avramov.statsservice.service;

import fr.avramov.statsservice.exception.StatsNotFoundException;
import fr.avramov.statsservice.model.TeamStats;
import fr.avramov.statsservice.model.PlayerStats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {
    private static List<PlayerStats> playerStats = PlayerStats.generatePlayerStats();
    private static List<TeamStats> teamStats = TeamStats.generateTeamStats();

    public TeamStats getTeamStats(Long teamId) {
        TeamStats teamStats = StatsService.teamStats.stream()
                .filter(teamStat -> teamStat.getTeamId().equals(teamId))
                .findFirst()
                .orElseThrow(() -> new StatsNotFoundException("Team stats not found"));
        if (teamStats == null) {
            throw new StatsNotFoundException("Team stats not found for id: " + teamId);
        }
        return teamStats;
    }

    public PlayerStats getPlayerStats(Long playerId) {
        PlayerStats playerStats = StatsService.playerStats.stream()
                .filter(playerStat -> playerStat.getPlayerId().equals(playerId))
                .findFirst()
                .orElseThrow(() -> new StatsNotFoundException("Player stats not found"));
        if (playerStats == null) {
            throw new StatsNotFoundException("Player stats not found for id: " + playerId);
        }
        return playerStats;
    }
}
