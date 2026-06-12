package section16.ImmutableClasses;

import java.util.Arrays;

public class PersonImmutable {
    
    //  Rules for a truly immutable object:

    //  RULE #1: all FIELDS PRIVATE and FINAL!
    private final String name;
    private final String dob;
    //          and now for something completely different;
    //          a new developer changed access modifier on kids to protected;
    // private final PersonImmutable[] kids;
    protected final PersonImmutable[] kids;


    
    //  RULE #4: use CONSTRUCTORS to populate data;
    public PersonImmutable(String name, String dob, PersonImmutable[] kids) {
        this.name = name; 
        this.dob = dob;
        //  for certain fields, specially collections, using constructors might not be good enough;
        //  as the calling code can subsequently mess with individual elements in the collection;
        //  (see MainRecord.java)
        //  Solution: initialize field with DEFENSIVE COPY;         (similar to defensive getters)
        this.kids = kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    public PersonImmutable(String name, String dob) {
        this(name, dob, null);
    }

    //          a new developer added a constructor that returns a copy of a PersonImmutable arg;
    protected PersonImmutable(PersonImmutable person) {
        this.name = person.name;
        this.dob = person.dob;
        this.kids = person.kids;
        // this(person.getName(), person.getDob(), person.getKids());
    }



    //  RULE #2: no SETTERS!
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public void setDob(String dob) {
    //     this.dob = dob;
    // }
    // public void setKids(Person[] kids) {
    //     this.kids = kids;
    // }

    //  RULE #3: DEFENSIVE GETTERS!
    public String getName() {
        //  string already immutable: no need to return a copy;
        return name;
    }
    public String getDob() {
        //  string already immutable: no need to return a copy;
        return dob;
    }
    public PersonImmutable[] getKids() {
        //  returns a copy of the array if not null;
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }



    @Override
    public String toString() {
        String kidsString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].getName());
            kidsString = String.join(", ", names);
        }
        return name + ", dob = " + getDob() + ", kids = " + kidsString;
    }

}
