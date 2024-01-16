package fr.avramov.teamservice.model;


public class PlayerDTO {
    private Long id;
    private String name;
    private String position;
    private int number;
    private Long teamId;

    // Constructeurs
    public PlayerDTO() {
    }
    public PlayerDTO(Long id, String name, String position, int number, Long teamId) {
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
                "id=" + id +
                ", name='" + name + "'" +
                ", position='" + position + "'" +
                ", number=" + number +
                '}';
    }

}
