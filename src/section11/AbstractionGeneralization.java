package section11;

public class AbstractionGeneralization {
    
    //  GENERALIZATION
    //  Before modeling objects for an application, you should study and IDENTIFY what FEATURES and BEHAVIOURS they have in common;
    //  This will allow you to create a CLASS HIERARCHY;
    //  When we create said class hierarchy, we are GENERALIZING features and behaviours;
    //  The BASE CLASS is the most generic, the most basic building block of an application;   

    //  ABSTRACTION
    //  Part of generalizing is using ABSTRACTION;
    //  You can GENERALIZE a set of FEATURES and BEHAVIOURS into an ABSTRACT TYPE;
    //  Example: an "animal" is an abstract concept, that can refer to many living beings that share the same features (a digestive, respiratory system, etc.) and behaviours (eat, sleep, breathe, run, fight, etc.);
    //  An "animal" doesn't really exist, except as a way to describe a more specific living thing (if you can't draw it on a piece of paper, it is probably an abstraction);
    
    //  Java supports abstraction in different ways:
    //          //  Abstract Classes;
    //          //  Interfaces;
    //          //  Class Hierarchy (usually the top base class is an abstract concept; it may or may not be an abstract class);



    //  ABSTRACT METHODS
    //  Abstract methods have a SIGNATURE and RETURN TYPE, but NO BODY!
    //  They can also be known as UNIMPLEMENTED METHODS;
    //  Their purpose is to describe behaviour, that can be implemented further down the class hierarchy;
    //  They can be thought of as a "CONTRACT" that classes who implement said interface/abstract class must fulfill;

    //  CONCRETE METHODS
    //  Concrete methods HAVE a BODY, i.e. operational code;
    //  Concrete method is said to IMPLEMENT an abstract method if it OVERRIDES one;
    //  They can be present in INTERFACES and ABSTRACT CLASSES!



    //  METHOD MODIFIERS
    //  In addition to ACCESS modifiers (public, protected, private, package), methods have other modifiers:
    //          //  abstract        //  method BODY always OMMITED; can only be declared on abstract classes or interfaces;
    //          //  static          //  called directly on the class instance; also known as a CLASS METHOD (vs. instance methods);
    //          //  final           //  cannot be OVERRIDEN by subclasses;
    //          //  default         //  only applicable to interfaces;
    //          //  native          //  body ommited, but differs from abstract; body will be implemented in platform dependent code (typically in C language); Very advanced topic;
    //          //  synchronized    //  manages how multiple threads access the code (see MULTI-THREADING sectionXX);


    public static void main(String[] args) {
        


    }

}
