package section17.Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamPipelines {

    //  Stream PIPELINES
    //          SOURCE: where the data comes from; starts/instantiates Stream object;
    //          TERMINAL Operation: produce a result or side-effect; ends the Stream;
    //          INTERMEDIATE Operations: anything between the source and terminal; 
    //  Intermediate Operations are not strictly required; You can have a Stream with just a Source and a Terminal;
    //  Every intermediate operation processes elements on the stream, and returns a stream object;

    //  Lambdas and Streams were built for each other, and are part of Java's tilt towards FUNCTIONAL programming;
    //  You can check which stream methods can act as a source, a terminal, or an intermediate operation in the Java Documentation:
    //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Stream.html#method-summary



    //  Streams are LAZY: 
    //          computation on the source data is only performed when the terminal operation is initiated;
    //          and source elements are consumed only as needed;

    //  One must imagine a Stream Pipeline as a BLACK BOX:
    //          Input is the Source;
    //          Output is the result of the terminal operation;
    //          Everything in between is not going to happen until terminal operation is triggered!

    //  What happens in the Black Box may or may not happen exactly as described, or in the specified order;
    //  This is unlike METHOD CHAINING:
    //          Guarantees the execution of every method;
    //          Occurs exactly in the defined order;

    //  Execution of the intermediate operations is dependent on:
    //          #1) a Termianl operation being specified;
    //          #2) an optimization process occurring;



    //  Stream computations are optimized for PERFORMANCE!
    //  The pipeline is more like a workflow SUGESTION, rather than an EXACT set of rules to follow;

    //  Before the process begins, the stream implementation performs an evaluation, to optimize the means to the end;
    //  It will determine the best way to get the needed elements, the most efficient way to process them, and provide the requested result;
    //  The RESULT will be CONSISTENT each time;
    //  The PROCESS to get to said result WILL NOT;

    //  Optimizations may change the order of intermediate operations, combine operations, or even skip operations!
    //  For this reason, one should AVOID SIDE-EFFECTS on INTERMEDIATE Operations!



    public static void main(String[] args) {
        
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



        //  This is a Stream Pipeline
        //  .stream() returns a Stream object;
        bingoPool.stream()                                                              //  Source: bingoPool
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted()
                .forEach(s -> System.out.print(s + " "))                                //  Terminal Operation
                ;
        System.out.println("\n" + "-".repeat(60));



        //  What if you ommit the Terminal Operation?
        bingoPool.stream()                                                              
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted()
                // .forEach(s -> System.out.print(s + " "))                                
                ;
        //  nothing happens;
        //  because Stream Pipeline only runs if a terminal is provided;
        //  a TERMINAL Operation is ALWAYS REQUIRED!
        System.out.println("\n" + "-".repeat(60));



        //  What if you assign Stream to a variable and append it later?
        var tempStream = bingoPool.stream()                                                              
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted()
                // .forEach(s -> System.out.print(s + " "))                               
                ;
        tempStream.forEach(s -> System.out.print(s + " "));
        //  it works!
        //  but intermediate operations will not be executed until a terminal is executed on the variable;
        System.out.println("\n" + "-".repeat(60));



        //  What if we call a terminal op for a 2nd time?
        // tempStream.forEach(s -> System.out.print(s.toLowerCase() + " "));               //  Runtime error!

        //  Stream has already been operated upon or closed!
        //  You cannot REUSE a Stream! 
    }
}
