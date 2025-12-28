package section7.POJOs;

public class POJOs {

    //  POJOs stand for PLAIN OLD JAVA OBJECTS;
    //  it only has INSTANCE VARIABLES;
    //  very few methods other than CONSTRUCTORS, GETTERS and SETTERS;
    //  used to house data and pass data between functional classes;
    //  many database frameworks use POJOs to read data from, or to write data to databases, files or streams;

    //  POJOs can also be known as BEANS or Java Beans (with a few extra rulles applied);
    //  POJOs can also be known as an ENTITY because it mirrors database entities;
    //  POJOs can also be known as DTOs DATA TRANSFER OBJECTS;

    //  POJOs are BOILERPLATE CODE (repetitive, and follow certain rules);

    public static void main(String[] args) {
        
        //  this loop will instantiate 5 students;
         for (int i = 1; i <= 5; i++) {
            StudentPOJO s = new StudentPOJO("S92300" + i,
                                    switch (i) {
                                        case 1 -> "Mary";
                                        case 2 -> "Carol";
                                        case 3 -> "Tim";
                                        case 4 -> "Harry";
                                        case 5 -> "Lisa";
                                        default -> "Anonymous";
                                    },
                                    "05/11/1995",
                                    "Java MasterClass");

            //  if you have a .TOSTRING method defined on your class, println() will implicitly use that method when you pass it a REFERENCE/INSTANCE;
            System.out.println(s);

         }



         //  OVERWRITTEN METHODS

    }

}
