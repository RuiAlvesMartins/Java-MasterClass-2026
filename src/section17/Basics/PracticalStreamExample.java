package section17.Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PracticalStreamExample {
    
    public static void main(String[] args) {

        //  A BINGO game will serve as example:
        //          B -> 1 through 15;
        //          I -> 16 through 30;
        //          N -> 31 through 45;
        //          G -> 46 through 60;
        //          O -> 61 through 75;
        
        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for(int i=start; i<(start+15); i++) {
                //  summing a char to an int will return an int;
                //  hence you add the "" to force it to concatenate them as a String;
                bingoPool.add("" + c + i);
                // System.out.println("" + c + i);                  //  for Debug purposes;
            }
            start+=15;
        }

        Collections.shuffle(bingoPool);
        for(int i = 0; i<15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-".repeat(60));

        // List<String> firstOnes = bingoPool.subList(0, 15);                          //  changes will affect original list;
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15));         //  changes will NOT affect original list;
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll(s -> {
            if (s.indexOf('G') == 0 || s.indexOf('O') == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.print(updated + " ");                 //  for Debug purposes;
                return updated;
            }
            return s;
        });
        System.out.println("\n" + "-".repeat(60));

        //  REMEMBER:  .subList() returns a VIEW!
        //  the changes made to the elements are reflected on the original bingoPool list!
        for(int i = 0; i<15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-".repeat(60));



        //  Now we will do the same, but with a STREAM;
        //  This order of statements is known as a Stream PIPELINE;
        bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted()
                .forEach(s -> System.out.print(s + " "))
                ;

        //  checking if changes mutated original list
        System.out.println("\n" + "-".repeat(60));
        for(int i = 0; i<15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-".repeat(60));

    }

}
