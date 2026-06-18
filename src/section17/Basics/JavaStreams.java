package section17.Basics;

public class JavaStreams {
    
    //  Java STREAMS
    //  Per Java Documentation: "a sequence of elements supporting sequential and parallel aggregate operations.";
    //  In other words, a strem is a set of computational steps against a data set, that are chained together;
    //  This is not the same as an I/O Stream;
    //  Introduced in JDK8;
    //  It is an Interface;

    //  Streams ARE NOT Collections!
    //  A Collection is used to STORE and MANAGE a series of ELEMENTS, providing direct ACCESS to them;
    //  E.g. you can use a collection to manupulate or querry a set of data;
    //  There's nothing you can do with a Stream, you couldn't already do with a Collection;

    //  A Stream is designed to manage the PROCESSING of elements;
    //  Streams DON'T STORE elements: they are computed on demand from a source;
    //  This source may be a COllection, an IO Stream or a database result;

    //  Java API developers designed Streams to allow the processing of data in a DECLARATIVE manner, like SQL;
    //  This let's programmer define what SHOULD happen, not exactly how it happens;
    


    //  LAZY EXECUTION
    //  When a Lambda expression is assigned to a variable, that get's called later;
    //  The associated logic is not executed when it is declared, but when the variable is called;

    //  Streams are a mechanism for describing a whole series of processes, before actually executing them;
    //  This means that when you call many of the methods on a stream, execution MAY NOT IMMEDIATLY occur;
    //  You MAY need to invoke a special operation on the stream (like you would by calling a lambda's functional method);
    //  This special (non-military) operation is called a TERMINAL OPERATION;



    //  Why use STREAMS instead of COLLECTIONS?
    //          #1) Streams make the processing code uniform, concise and repeatable, much alike SQL;
    //          #2) When working with large collections, parallel streams provide a PERFORMANCE advantage;

    //  The Collection interface declares:
    //          .stream()
    //          .parallelStream()
    //  A Stream can be created from any Collection type!         




}
