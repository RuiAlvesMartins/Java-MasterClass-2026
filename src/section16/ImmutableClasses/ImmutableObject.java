package section16.ImmutableClasses;

public class ImmutableObject {
    
    //  IMMUTABLE OBJECT

    //  An immutable object doesn't change it's STATE, a.k.a. the internal data on it's fields;
    //  It is a SECURE object: calling code can't alter it, maliciously or by mistake;
    //  Simplifies concurrency design;

    //  What characteristics can be found in an Immutable Object?
    //          FIELDS are Private and Final;
    //          No SETTER methods defined;
    //          GETTERS return defensive COPIES;
    //          Data is set at the constructor/factory method, making copies of mutable reference data;
    //          CLASS is marked Final, or all constructors are private;

}
