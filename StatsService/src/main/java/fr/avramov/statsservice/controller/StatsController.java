package fr.avramov.statsservice.controller;

import fr.avramov.statsservice.model.TeamStats;
import fr.avramov.statsservice.model.PlayerStats;
import fr.avramov.statsservice.service.StatsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @ApiOperation(value = "Get team stats by team id", notes = "Provide an id to look up specific team stats", response = TeamStats.class)
    @GetMapping("/team-stats/{teamId}")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<TeamStats> getTeamStats(
            @ApiParam(value = "ID of the team to retrieve stats for", required = true)
            @PathVariable Long teamId) {
        TeamStats teamStats = statsService.getTeamStats(teamId);
        return ResponseEntity.ok(teamStats);
    }

    @ApiOperation(value = "Get player stats by player id", notes = "Provide an id to look up specific player stats", response = PlayerStats.class)
    @GetMapping("/player-stats/{playerId}")
    public ResponseEntity<PlayerStats> getPlayerStats(
            @ApiParam(value = "ID of the player to retrieve stats for", required = true)
            @PathVariable Long playerId) {
        PlayerStats playerStats = statsService.getPlayerStats(playerId);
        return ResponseEntity.ok(playerStats);
    }
}
