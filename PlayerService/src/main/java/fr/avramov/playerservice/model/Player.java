package fr.avramov.playerservice.model;


import java.util.ArrayList;
import java.util.List;

public class Player {
    private Long id;
    private String name;
    private String position;
    private int number;
    private Long teamId;

    // Constructeurs
    public Player(Long id, String name, String position, int number, Long teamId) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.number = number;
        this.teamId = teamId;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public Long getTeamId() {
        return teamId;
    }

    // Setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    // ToString en JSON
    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", name: '" + name + "'" +
                ", position: '" + position + "'" +
                ", number: " + number +
                ", teamId: " + teamId +
                '}';
    }

    public static List<Player> generatePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1L, "Player 1", "Forward", 10, 1L));
        players.add(new Player(2L, "Player 2", "Midfielder", 7, 1L));
        players.add(new Player(3L, "Player 3", "Defender", 5, 1L));
        players.add(new Player(4L, "Player 4", "Goalkeeper", 1, 1L));
        players.add(new Player(5L, "Player 5", "Forward", 9, 1L));
        players.add(new Player(6L, "Player 6", "Midfielder", 8, 2L));
        players.add(new Player(7L, "Player 7", "Defender", 6, 2L));
        players.add(new Player(8L, "Player 8", "Goalkeeper", 1, 2L));
        players.add(new Player(9L, "Player 9", "Forward", 11, 2L));
        players.add(new Player(10L, "Player 10", "Midfielder", 6, 2L));
        return players;
    }


}
