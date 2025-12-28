package section12.GenericClasses;

public class Main {
    
    public static void main(String[] args) {

        var philly = new Affiliation("City", "Philadelphia, PA", "US");

        //  BaseballTeam is a regular class;
        BaseballTeam philliesDemo1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astrosDemo1 = new BaseballTeam("Houston Astros");
        scoreResult(philliesDemo1, 3, astrosDemo1, 5);

        //  SportsTeam is a pseudo-generic class (copyed from BaseballTeam), that can work for both Basketball and Football teams, with some limitations;
        SportsTeam philliesDemo2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astrosDemo2 = new SportsTeam("Houston Astros");
        scoreResult(philliesDemo2, 3, astrosDemo2, 5);

        //  Team is a truly GENERIC class (copyed from SportsTeam), that can work for both Basketball and Football teams;
        Team<BaseballPlayer, Affiliation> phillies = new Team<>("Philadelphia Phillies", philly);
        Team<BaseballPlayer, Affiliation> astros = new Team<>("Houston Astros");
        scoreResult(phillies, 3, astros, 5);

        //  Remember: var is the Variable Inference Type
        //  reference variable will assume the type of assigned instance;
        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        var gutrie = new BaseballPlayer("D Guthrie", "Center Fielder");
        phillies.addTeamMember(gutrie);
        phillies.listTeamMembers();

        SportsTeam afcDemo = new SportsTeam("Adelaide Crows");
        Team<FootballPlayer, String> afc = new Team<>("Adelaide Crows", 
            "City of Adelaide, South Australia, in AU");
        var tex = new FootballPlayer("Tex Walker", "Center Half Forward");
        afc.addTeamMember(tex);
        //  You are now prevented from adding BasketballPlayer to afc!
        // afc.addTeamMember(gutrie);                                                   //  Compiler error!
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        // //  Team<> also worked with Strings as parameter type;
        // Team<String> adelaide = new Team<>("Adelaide Storm");
        // adelaide.addTeamMember("N Roberts");
        // adelaide.listTeamMembers();

        // //  Remember: if you don't declare parameter type on the reference variable, you must declare it on the instantiation!
        // var canberra = new Team<String>("Canberra Heat");
        // canberra.addTeamMember("B Black");
        // canberra.listTeamMembers();
        // scoreResult(canberra, 0, adelaide, 1);

        // Team<Integer> melbourneVB = new Team<>("Melbourne Vipers");


        Team<VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
        adelaide.listTeamMembers();

        var canberra = new Team<VolleyballPlayer, Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        scoreResult(canberra, 0, adelaide, 1);

    }

    public static void scoreResult(BaseballTeam team1, int t1Score,
                                   BaseballTeam team2, int t2Score) {
        
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1Score,
                                   SportsTeam team2, int t2Score) {
        
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    //  RAW TYPE warning on Team arguments;
    //  For now this will work, because it is a STATIC method;
    //  And we need to pass Basketball and Football players;
    public static void scoreResult(Team team1, int t1Score,
                                   Team team2, int t2Score) {
        
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

}
