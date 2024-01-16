package fr.avramov.playerservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import fr.avramov.playerservice.exception.PlayerNotFoundException;
import fr.avramov.playerservice.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PlayerService {

    List<Player> players = Player.generatePlayers();

    public Player getPlayerById(Long id) {
        Player founded = null;
        for (Player player : players) {
            if (Objects.equals(player.getId(), id)) {
                founded = player;
            }
        }
        if (founded == null) {
            throw new PlayerNotFoundException("Player not found with id: " + id);
        }
        return founded;
    }

    @HystrixCommand(fallbackMethod = "getPlayerByIdFallback")
    public Player createPlayer(Player player) {
        // Assurez-vous que l'ID du joueur n'est pas défini pour éviter les conflits
        if (player.getId() != null) {
            throw new IllegalArgumentException("Id must be null for a new Player");
        }

        // Générez un nouvel ID pour le joueur (vous pouvez utiliser une logique personnalisée ici)
        Long newId = players.stream()
                .map(Player::getId)
                .max(Long::compareTo)
                .orElse(0L) + 1;
        player.setId(newId);

        players.add(player);
        return player;
    }

    public Player updatePlayer(Long id, Player playerDetails) {
        Player player = getPlayerById(id); // Reuse the method to get the player or throw if not found
        player.setName(playerDetails.getName());
        player.setPosition(playerDetails.getPosition());
        player.setNumber(playerDetails.getNumber());
        player.setTeamId(playerDetails.getTeamId());

        return player;
    }

    public void deletePlayer(Long id) {
        // Recherchez le joueur existant par ID
        Player existingPlayer = getPlayerById(id);

        // Supprimez le joueur de la liste
        players.remove(existingPlayer);
    }


    public List<Player> getPlayersByTeam(Long teamId) {
        ArrayList<Player> founded = new ArrayList<>();
        for (Player player : players) {
            if (Objects.equals(player.getTeamId(), teamId)) {

                founded.add(player);
            }
        }
        return founded;
    }
}
