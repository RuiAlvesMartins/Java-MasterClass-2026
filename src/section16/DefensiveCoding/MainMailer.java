package section16.DefensiveCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainMailer {
    
    public static void main(String[] args) {
        
        String[] names = {"Ann Jones", "Ann Jones Ph.D.", "Bob Jones M.D.", 
                "Carol Jones", "Ed Green Ph.D.", "Ed Green M.D.", "Ed Black"};

        List<StringBuilder> population = getNames(names);
        population.forEach(System.out::println);
        Map<StringBuilder, Integer> counts = new TreeMap<>();
        population.forEach(s -> {
            counts.merge(s, 1, Integer::sum);
        });
        counts.forEach((k, v) -> System.out.print(k + " #" + v + "; "));

        System.out.printf("%n%n");
        StringBuilder annJonesPhd = new StringBuilder("Ann Jones Ph.D.");
        System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd);

        List<StringBuilder> cleanedNames = standardizeNames(population);
        System.out.println(cleanedNames);

        //  although we are standardizing the names on a different collection (cleanedNames);
        //  remember that, unlike String, StringBuilder is MUTABLE!
        //  the changes .standardizeNames() made on the StringBuilder elements...
        //  ...will show on (population) and (count) because they are composed of those same elements!
        System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd);
        //  we now have duplicate names as keys on (counts)!
        System.out.println(counts);
        StringBuilder annJones = new StringBuilder("Ann Jones");
        System.out.println("There are " + counts.get(annJones) + " records for " + annJones);

        System.out.println("-".repeat(30));
        counts.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("-".repeat(30));
        counts.keySet().forEach(k -> System.out.println(k + " : #" + counts.get(k)));



        //  the .standardizeNames() seemed harmless enough...
        //  ...but produced very ugly SIDE-EFFECTS!

        //  it changed names not only in one collection
        //  but in all others that shared the same INSTANCES!
        //  this is why using IMUTABLE objects (e.g. String!) is often a good idea!
        //  and absolutely mandatory for MAP KEYS!      (you really don't want what happened to count.keySet(), do you?)

    }



    private static List<StringBuilder> getNames(String[] names) {
        
        List<StringBuilder> list = new ArrayList<>();
        int index = 3;
        for (String name : names) {
            for(int i=0; i<index; i++) {
                list.add(new StringBuilder(name));
            }
            index++;
        }
        return list;

    }

    private static List<StringBuilder> standardizeNames(List<StringBuilder> list) {

        List<StringBuilder> newlist = new ArrayList<>();
        for (var name : list) {
            for (String suffix : new String[]{"Ph.D.", "M.D."}) {
                int startIndex = -1;
                if ((startIndex = name.indexOf(suffix)) > -1) {
                    name.replace(startIndex -1, 
                        startIndex + suffix.length(), "");
                }
            }
            newlist.add(name);
        }
        return newlist;

    }

}
