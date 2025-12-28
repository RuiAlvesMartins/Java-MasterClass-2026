package section12.GenericClasses;

import java.util.ArrayList;
import java.util.List;

public class SportsTeam {

    private String teamName;
    //  List is a GENERIC INTERFACE;
    //  ArrayList is a GENERIC CLASS;
    //  Using the interface for the reference type is a best practice known as CODING TO AN INTERFACE;
    private List<Player> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(Player player) {
        //  teamMembers is a list of Player, and Player interface is implemented by Records;
        //  because RECORD has an implicit EQUALS(), we can use CONTAINS();
        if (!teamMembers.contains(player)) {
            teamMembers.add(player);
        }
    }

    public void listTeamMembers() {
        System.out.println(teamName + " Roster:");
        //  Remember: you can pass an ArrayList in a sout and all elements will be printed;
        System.out.println(teamMembers);
    }

    public int ranking() {
        //  totally made up logic for demonstration purposes;
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        String message = "";
        if (ourScore > theirScore) {
            totalWins++;
            message = "beat";
        }
        if (ourScore < theirScore) {
            totalLosses++;
            message = "lost to";
        }
        if (ourScore == theirScore) {
            totalTies++;
            message = "tied";
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }

}

