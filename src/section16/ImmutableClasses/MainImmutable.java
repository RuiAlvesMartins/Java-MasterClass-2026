package section16.ImmutableClasses;

import section16.ImmutableClasses.MaliciousHackerCode.PersonOfInterest;

public class MainImmutable {
    
    public static void main(String[] args) {
        
        PersonImmutable jane = new PersonImmutable("Jane", "01/01/1930");
        PersonImmutable jim = new PersonImmutable("Jim", "02/02/1932");
        PersonImmutable joe = new PersonImmutable("Joe", "03/03/1934");

        PersonImmutable[] johnsKids = {jane, jim, joe};
        PersonImmutable john = new PersonImmutable("John", "05/05/1900", johnsKids);
        System.out.println(john);
        //  OUTPUT:     John, dob = 05/05/1900, kids = Jane, Jim, Joe

        PersonImmutable[] kids = john.getKids();
        kids[0] = jim;
        kids[1] = new PersonImmutable("Ann", "04/04/1936");
        System.out.println(john);
        //  OUTPUT:     John, dob = 05/05/1900, kids = Jane, Jim, Joe
        //  John's kids are still the same!
        //  Protected by: defensive getter!

        johnsKids[0] = new PersonImmutable("Ann", "04/04/1936");
        System.out.println(john);
        //  OUTPUT:     John, dob = 05/05/1900, kids = Jane, Jim, Joe
        //  John's kids are still the same!
        //  Protected by: defensive copy on constructor!



        LivingPerson johnLiving  = new LivingPerson(john.getName(), john.getKids());
        System.out.println(johnLiving);

        LivingPerson ann = new LivingPerson("Ann", null);
        johnLiving.addKid(ann);
        System.out.println(johnLiving);

        //  evil, nefarious, hacking code messing with our beautifull, immutable, wonderfull class:
        PersonOfInterest johnCopy = new PersonOfInterest(john);
        System.out.println(johnCopy);
        //  OUTPUT:     John, dob = 05/05/1900, kids = Jane, Jim, Joe

        kids = johnCopy.getKids();
        kids[1] = ann;
        System.out.println(johnCopy);
        //  OUTPUT:     John, dob = 05/05/1900, kids = Jane, Ann, Joe
        System.out.println(john);
        //  OUTPUT:     John, dob = 05/05/1900, kids = Jane, Ann, Joe
        //  You got HACKED!



        //  This class was IMMUTABLE... at first
        //  The new developer made two big mistakes:
        //          Opening the access modifier on kids field to protected;
        //          Overloading a constructor that sets kids with an original instance, instead of a defensive copy;
        //  How to solve this?
        //          Revert kids field to private OR declare .getKids() final;
        //          Set fields to defensive copies on the new overloaded constructor;
        //  final .getKids() prevents the method from being overriden;
        //  but will still allow direct access to kids field by methods with a different signature;
        //  those methods cannot be called polymorphically by unsuspecting code though;

    }

}
