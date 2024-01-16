package fr.avramov.matchservice.controller;

import fr.avramov.matchservice.model.Match;
import fr.avramov.matchservice.service.MatchService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @ApiOperation(value = "Get a match by ID", notes = "Provide an ID to look up a specific match", response = Match.class)
    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(
            @ApiParam(value = "ID of the match to retrieve", required = true)
            @PathVariable Long id) {
        Match match = matchService.getMatchById(id);
        return ResponseEntity.ok(match);
    }

    @ApiOperation(value = "Create a new match", notes = "Submit a Match object to create a new match", response = Match.class)
    @PostMapping
    public ResponseEntity<Match> createMatch(
            @ApiParam(value = "Match object to be created", required = true)
            @RequestBody Match match) {
        Match newMatch = matchService.createMatch(match);
        return ResponseEntity.ok(newMatch);
    }

    @ApiOperation(value = "Update a match", notes = "Provide an ID and a Match object to update an existing match", response = Match.class)
    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(
            @ApiParam(value = "ID of the match to be updated", required = true)
            @PathVariable Long id,
            @ApiParam(value = "Updated Match object", required = true)
            @RequestBody Match match) {
        Match updatedMatch = matchService.updateMatch(id, match);
        return ResponseEntity.ok(updatedMatch);
    }

    @ApiOperation(value = "Delete a match", notes = "Provide an ID to delete a specific match")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(
            @ApiParam(value = "ID of the match to be deleted", required = true)
            @PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.ok().build();
    }
}