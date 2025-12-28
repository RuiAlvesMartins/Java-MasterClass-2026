package section11.Challenges.MappableClasses;

enum Geometry {
    POINT,
    LINE,
    POLIGON
}

enum PointMarker {
    STAR,
    CIRCLE,
    CROSS,
    SQUARE,
    TRIANGLE,
    DIAMOND
}

enum LineMarker {
    SOLID,
    DOTTED,
    DASHED
}

enum Color {
    RED,
    GREEN,
    BLUE,
    BLACK,
    WHITE,
    ORANGE,
    YELLOW
}

public interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s} 
            """;
        // "\n" + 
        //     " \"properties\": {" + 
        //         "\"type\": \"%s\", " + 
        //         " \"label\": \"%s\", " + 
        //         " \"marker\": \"%s\"}" + 
        // "\n";

    Geometry getShape();
    String getLabel();
    String getMarker();

    default String toJSON() {
        String jsonString = """
                "type": "%s", "label": "%s", "marker": "%s" """.formatted(getShape(), getLabel(), getMarker());
        return jsonString;
    }

    static void mapIt(Mappable instance) {
        //  should print properties of mappable type;
        //  but also fields on business classes;
        System.out.println(JSON_PROPERTY.formatted(instance.toJSON()));
    }

}
