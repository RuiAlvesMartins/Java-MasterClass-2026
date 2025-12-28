package section7.Strings;

public class StringBuilderClass {

    //  STRINGS are IMUTABLE!
    //  STRINGBUILDER are not!

    //  String methods create and return a NEW object in memory;
    //  StringBuilder methods return the same object, but altered;

    //  StringBuilder has similar methods to String, but also has methods to remove and insert characters;
    //  delete()
    //  deleteCharAt()
    //  insert()
    //  reverse()
    //  setLength()

    //  CAPACITY is how many characters a StringBuilder object can hold, before requesting more memory;

    public static void main(String[] args) {
        
        String helloWorld = "Hello" + " World!";
        helloWorld.concat(" and Goodbye");

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World!");
        helloWorldBuilder.append(" and Goodbye");

        //  this will not print the mutated string, because strings are imutable!
        printInformation(helloWorld);
        //  this will print the mutated string!
        printInformation(helloWorldBuilder);

        StringBuilder emptyStart = new StringBuilder();
        emptyStart.append("a".repeat(17));
        //  when you pass an integer to StringBuilder constructor, it defines CAPACITY;
        StringBuilder emptyStart2 = new StringBuilder(32);
        emptyStart2.append("a".repeat(17));

        printInformation(emptyStart);
        printInformation(emptyStart2);

        //  deleteCharAt() and insert()
        StringBuilder builderPlus = new StringBuilder("Hello" + " World!");
        builderPlus.append(" and Goodbye");
        builderPlus.deleteCharAt(17).insert(17, 'g');
        System.out.println(builderPlus);

        //  replace()
        builderPlus.replace(17, 18, "G");
        System.out.println(builderPlus);

        //  reverse()
        builderPlus.reverse().setLength(7);
        System.out.println(builderPlus);

    }

    public static void printInformation(String string) {
        
        System.out.println("String = " + string);
        System.out.println("length = " + string.length());

    }

    public static void printInformation(StringBuilder builder) {
        
        System.out.println("StringBuilder = " + builder);
        System.out.println("length = " + builder.length());
        System.out.println("capacity = " + builder.capacity());

    }

}
