package section16.Mutability;

public class OnMutability {
    
    //  Mutability

    //  Objects have STATE, i.e. data stored in instance FIELDS;
    //  State can change after an object is created, intentionally or not;

    //  IMMUTABLE Objects
    //  Their internal state remains CONSTANT throughout their lifetime;
    //  Code is prevented from changing the state;
    //  Are not subject to SIDE-EFFECTS (unwanted, unplanned or unintended modifications);
    //  Lesser need for DEFENSIVE coding;
    //  Inherently THREAD-SAFE, because no threads can change these objects after their construction;
    //  Management of ACCESS SYNCHRONIZATION unneccessary, more EFFICIENT collections and operations can be used;

    //  MUTABLE Objects
    //  Their internal state does NOT remain constant;
    //  Can change it's state. No need to instantiate a new object or make a copy of it.


    //  String VS. StringBuilder 
    //  String is IMMUTABLE;
    //  StringBuilder is mutable;
    //  If you constantly need to alter text values, it is more efficient to use a StringBuilder;


    //  POJOs and Java BEANS are, by default, NOT IMMUTABLE!
}
