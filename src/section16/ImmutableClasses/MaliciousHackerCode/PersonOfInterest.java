package section16.ImmutableClasses.MaliciousHackerCode;

import section16.ImmutableClasses.PersonImmutable;

public class PersonOfInterest extends PersonImmutable {

    public PersonOfInterest(PersonImmutable person) {
        super(person);
    }

    @Override
    public PersonImmutable[] getKids() {
        //  because that new developer changed the access modifier on kids to protected;
        //  I, nefarious, malicious, evil, hacker can return the kids instance directly:
        return super.kids;
        //  (child classes have access to protected fields/methods on the parent class, remember?)
    }

    

}
