package fr.avramov.playerservice.controller;

import fr.avramov.playerservice.model.Player;
import fr.avramov.playerservice.service.PlayerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @ApiOperation(value = "Get a player by ID", notes = "Provide an ID to look up a specific player", response = Player.class)
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(
            @ApiParam(value = "ID of the player to retrieve", required = true)
            @PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @ApiOperation(value = "Get all players by team", notes = "Get all players by team", response = Player.class)
    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<Player>> getPlayersByTeam(
            @ApiParam(value = "ID of the team", required = true)
            @PathVariable Long teamId) {
        List<Player> players = playerService.getPlayersByTeam(teamId);
        return ResponseEntity.ok(players);
    }

    @ApiOperation(value = "Create a new player", notes = "Submit a Player object to create a new player", response = Player.class)
    @PostMapping
    public ResponseEntity<Player> createPlayer(
            @ApiParam(value = "Player object to be created", required = true)
            @RequestBody Player player) {
        Player newPlayer = playerService.createPlayer(player);
        return ResponseEntity.ok(newPlayer);
    }

    @ApiOperation(value = "Update a player", notes = "Provide an ID and a Player object to update an existing player", response = Player.class)
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(
            @ApiParam(value = "ID of the player to be updated", required = true)
            @PathVariable Long id,
            @ApiParam(value = "Updated Player object", required = true)
            @RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(id, player);
        return ResponseEntity.ok(updatedPlayer);
    }

    @ApiOperation(value = "Delete a player", notes = "Provide an ID to delete a specific player")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(
            @ApiParam(value = "ID of the player to be deleted", required = true)
            @PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok().build();
    }
}
