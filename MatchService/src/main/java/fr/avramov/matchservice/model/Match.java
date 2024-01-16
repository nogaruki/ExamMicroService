package fr.avramov.matchservice.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {

    private Long id;

    private Long team1;

    private Long team2;

    private Integer scoreTeam1;

    private Integer scoreTeam2;

    private Date date;

    private String lieu;

    // Constructeurs
    public Match(Long id, Long team1, Long team2, Integer scoreTeam1, Integer scoreTeam2, Date date, String lieu) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
        this.date = date;
        this.lieu = lieu;
    }

    // Getter

    public Long getId() {
        return id;
    }

    public Long getTeam1() {
        return team1;
    }

    public Long getTeam2() {
        return team2;
    }

    public Integer getScoreTeam1() {
        return scoreTeam1;
    }

    public Integer getScoreTeam2() {
        return scoreTeam2;
    }

    public String getGlobalScore() {
        return scoreTeam1 + " - " + scoreTeam2;
    }

    public Date getDate() {
        return date;
    }
    public String getLieu() {
        return lieu;
    }

    // Setter

    public void setTeam1(Long team1) {
        this.team1 = team1;
    }

    public void setTeam2(Long team2) {
        this.team2 = team2;
    }

    public void setScoreTeam1(Integer scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public void setScoreTeam2(Integer scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public static List<Match> generateMatches() {
        List<Match> matches = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // Match 1
            Date date1 = dateFormat.parse("2023-03-15 18:30:00");
            Match match1 = new Match(1L, 1L, 2L, 3, 2, date1, "Stadium A");
            matches.add(match1);

            // Match 2
            Date date2 = dateFormat.parse("2023-03-20 20:00:00");
            Match match2 = new Match(2L, 2L, 1L, 1, 1, date2, "Stadium B");
            matches.add(match2);

            // Match 3
            Date date3 = dateFormat.parse("2023-03-25 17:45:00");
            Match match3 = new Match(3L, 1L, 2L, 2, 3, date3, "Stadium C");
            matches.add(match3);

            // Match 4
            Date date4 = dateFormat.parse("2023-03-30 19:15:00");
            Match match4 = new Match(4L, 2L, 1L, 0, 2, date4, "Stadium A");
            matches.add(match4);

            // Match 5
            Date date5 = dateFormat.parse("2023-04-05 16:00:00");
            Match match5 = new Match(5L, 1L, 2L, 1, 1, date5, "Stadium B");
            matches.add(match5);

            // Match 6
            Date date6 = dateFormat.parse("2023-04-10 21:30:00");
            Match match6 = new Match(6L, 2L, 1L, 2, 2, date6, "Stadium C");
            matches.add(match6);

            // Match 7
            Date date7 = dateFormat.parse("2023-04-15 19:45:00");
            Match match7 = new Match(7L, 1L, 2L, 0, 3, date7, "Stadium A");
            matches.add(match7);

            // Match 8
            Date date8 = dateFormat.parse("2023-04-20 17:30:00");
            Match match8 = new Match(8L, 2L, 1L, 2, 1, date8, "Stadium B");
            matches.add(match8);

            // Match 9
            Date date9 = dateFormat.parse("2023-04-25 20:15:00");
            Match match9 = new Match(9L, 1L, 2L, 1, 0, date9, "Stadium C");
            matches.add(match9);

            // Match 10
            Date date10 = dateFormat.parse("2023-04-30 18:00:00");
            Match match10 = new Match(10L, 2L, 1L, 3, 1, date10, "Stadium A");
            matches.add(match10);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return matches;
    }
}
