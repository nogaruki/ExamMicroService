package fr.avramov.teamservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import fr.avramov.teamservice.model.PlayerDTO;
import fr.avramov.teamservice.model.Team;
import fr.avramov.teamservice.service.TeamService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private String playerServiceUrl = "http://localhost:8082/";

    @Autowired
    private TeamService teamService;

    private final RestTemplate restTemplate = new RestTemplate();


    @ApiOperation(value = "Get a team by ID", notes = "Provide an ID to look up a specific team", response = Team.class)
    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "getTeamByIdFallback")
    public ResponseEntity<Team> getTeamById(
            @ApiParam(value = "ID of the team to retrieve", required = true)
            @PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        ResponseEntity<PlayerDTO[]> response = restTemplate.exchange(
                playerServiceUrl+"players/team/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PlayerDTO[]>() {});
        PlayerDTO[] playerDTO = response.getBody();
        team.setPlayers(playerDTO);
        return ResponseEntity.ok(team);
    }

    @ApiOperation(value = "Create a new team", notes = "Submit a Team object to create a new team", response = Team.class)
    @PostMapping
    public ResponseEntity<Team> createTeam(
            @ApiParam(value = "Team object to be created", required = true)
            @RequestBody Team team) {
        return ResponseEntity.ok(teamService.createTeam(team));
    }

    @ApiOperation(value = "Update a team", notes = "Provide an ID and a Team object to update an existing team", response = Team.class)
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(
            @ApiParam(value = "ID of the team to be updated", required = true)
            @PathVariable Long id,
            @ApiParam(value = "Updated Team object", required = true)
            @RequestBody Team team) {
        return ResponseEntity.ok(teamService.updateTeam(id, team));
    }

    @ApiOperation(value = "Delete a team", notes = "Provide an ID to delete a specific team")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(
            @ApiParam(value = "ID of the team to be deleted", required = true)
            @PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok().build();
    }

    public Team getTeamByIdFallback(Long id) {
        return new Team(id, "Team not found");
    }
}
