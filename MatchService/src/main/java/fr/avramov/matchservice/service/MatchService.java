package fr.avramov.matchservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import fr.avramov.matchservice.exception.MatchNotFoundException;
import fr.avramov.matchservice.model.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private List<Match> matches = Match.generateMatches();

    public Match getMatchById(Long id) {
        return matches.stream()
                .filter(match -> match.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new MatchNotFoundException("Match not found"));
    }
    public Match createMatch(Match match) {
        if (match.getId() != null) {
            throw new IllegalArgumentException("Id must be null for a new Match");
        }
        matches.add(match);
        return match;

    }

    public Match updateMatch(Long id, Match matchDetails) {
        Match match = getMatchById(id); // Reuse the method to get the player or throw if not found
        match.setDate(matchDetails.getDate());
        match.setLieu(matchDetails.getLieu());
        match.setScoreTeam1(matchDetails.getScoreTeam1());
        match.setScoreTeam2(matchDetails.getScoreTeam2());
        match.setTeam1(matchDetails.getTeam1());
        match.setTeam2(matchDetails.getTeam2());
        return match;
    }

    public void deleteMatch(Long id) {
        Match match = getMatchById(id); // Reuse the method to get the player or throw if not found
        matches.remove(match);
    }
}
