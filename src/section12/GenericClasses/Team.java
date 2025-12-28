package section12.GenericClasses;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player, S> {

    private String teamName;
    //  List is a GENERIC INTERFACE;
    //  ArrayList is a GENERIC CLASS;
    //  Using the interface for the reference type is a best practice known as CODING TO AN INTERFACE;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this(teamName);
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t) {
        //  teamMembers is a list of T, and T is a TYPE PARAMETER;
        //  Since we are passing Records BaseballPlayer and FootballPlayer as T, we can use the CONSTAINS();
        //  Because RECORD has an implicit EQUALS();
        //  If we pass a class/record without an equals(), this will break the code;
        if (!teamMembers.contains(t)) {
            teamMembers.add(t);
        }
    }

    public void listTeamMembers() {
        System.out.print(teamName + " Roster:");
        System.out.println(affiliation != null ? " AFFILIATION: " + affiliation : "");
        //  Remember: you can pass an ArrayList in a sout and all elements will be printed;
        // System.out.println(teamMembers);
        for (T t : teamMembers) {
            System.out.println(t.name());
        }
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

