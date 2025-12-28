package section12.Challenges.GenericClassChallengeBuildingReusableStructures;

public class River implements Mappable {

    private Line line;
    private String name;

    public River(String name, Line line) {
        this.line = line;
        this.name = name;
    }

    public River(String name) {
        this(name, new Line());
    }

    public Line getLine() {
        return line;
    }

    public String getName() {
        return name;
    }

    public String render() {
        String string = "Render %s as %s (%s)".formatted(
                            this.name, 
                            this.line.getClass().getSimpleName().toUpperCase(),
                            this.line.render()
                        );
        return string;
    }

}
