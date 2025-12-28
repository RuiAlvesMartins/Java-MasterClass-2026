package section7.Strings;

import java.util.Arrays;

public class StringMethodsAndBestPractices {

    //  STRINGS are IMUTABLE!
    //  Because of this, each method call returns a new string object!

    //  STRING INSPECTION METHODS
    //  length()                            //  returns number of characters in string;
    //  charAt()                            //  returns character at index n; index count starts at 0;
    //  indexOf()                           //  returns an int representing the position of the argument in the string if found; returns -1 if not found;
    //  lastIndexOf()                       //  returns an int representing the position of the argument in the string if found; returns -1 if not found; counts backwards;
    //  isEmpty()                           //  returns true if length() is 0;
    //  isBlank()                           //  returns true if length() is 0 OR string only contains whitespace;

    //  STRING COMPARISON METHODS
    //  contentEquals()                     //  returns true if string is equal to argument; it can compare objects other than strings;    
    //  equals()                            //  returns true if string is equal to argument;
    //  equalsIgnoreCase()                  //  returns true if string is equal to argument, ignoring case;     
    //  contains()                          //  returns true if string contains argument;                                              
    //  startsWith()                        //  returns true if string starts with argument;
    //  endsWith()                          //  returns true if string ends with argument;
    //  regionMatches()                     //  returns true if defined sub-regions are matched;

    //  STRING MANIPULATION METHODS
    //  concat()                            //  returns a new string with the argument concatenated; similar to the + sign;
    //  join()                              //  allows multiple strings to be concatenated; specifies a delimiter    
    //  repeat()                            //  returns the string repeated n number of times;    
    //  replace()                           //  replace characters or expressions within a string;
    //  replaceAll()                        //  replace characters or expressions within a string;
    //  replaceFirst()                      //  replace characters or expressions within a string;
    //  substring()                         //  returns part of a string, start and end specified by arguments;    
    //  subSequence()                       //  returns part of a string, start and end specified by arguments;
    //  indent()                            //  adds or removes whitespace from the begining of line;
    //  toLowerCase()                       //  formats all characters to lower case;    
    //  toUpperCase()                       //  formats all characters to upper case;
    //  strip()                             //  cleans the text of white spaces;
    //  stripLeading()                      //                                              
    //  stripTrailing()                     //  
    //  trim()                              // 
    //  split()                             //  returns a String[] with the pieces of the string split by the regex argument;

    public static void main(String[] args) {
        


        //  STRING INSPECTION METHODS

        String helloWorld = "Hello World!";
        String emptyString = "";
        String blankString = "\t \n";

        //  printInformation() covers length(), charAt(), isEmpty(), isBlank();
        printInformation(helloWorld);
        printInformation(emptyString);
        printInformation(blankString);

        //  indexOf() returns an int representing the position of the argument in the string if found; returns -1 if not found;
        System.out.printf("index of r = %d %n", helloWorld.indexOf('r'));
        System.out.printf("index of World = %d %n", helloWorld.indexOf("World"));

        System.out.printf("index of l = %d %n", helloWorld.indexOf('l'));
        //  indexOf() returns an int representing the position of the argument in the string if found; returns -1 if not found; conts backwards
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l'));

        //  if you pass an int as a second argument, it will start counting from that position;
        System.out.printf("index of l = %d %n", helloWorld.indexOf('l', 2 + 1));
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l', 9 - 1));



        //  STRING COMPARISON METHODS

        String helloWorldLower = helloWorld.toLowerCase();

        //  equals() returns true if string is equal to argument;
        if (helloWorld.equals(helloWorldLower)) {
            System.out.println("Values match exactly");
        }

        //  contentEquals() returns true if string is equal to argument; it can compare objects other than strings;
        if (helloWorld.contentEquals("Hello World!")) {
            System.out.println("Values match exactly");
        }

        //  equalsIgnoreCase() returns true if string is equal to argument, ignoring case;
        if (helloWorld.equalsIgnoreCase(helloWorldLower)) {
            System.out.println("Values match ignoring case");
        }

        //  startsWith() returns true if string starts with argument;
        if (helloWorld.startsWith("Hello")) {
            System.out.println("String starts with Hello");
        }

        //  endsWith() returns true if string ends with argument;
        if (helloWorld.endsWith("World")) {
            System.out.println("String ends with World");
        }

        //  contains() returns true if string contains argument;
        if (helloWorld.contains("World")) {
            System.out.println("String contains World");
        }



        //  STRING MANIPULATION METHODS

        String birthDate = "25/11/1982";
        int startingIndex = birthDate.indexOf("1982");
        System.out.println("startingIndex = " + startingIndex);
        //  substring() returns the part of the string after the given index;
        System.out.println("Birth year = " + birthDate.substring(startingIndex));
        //  if you provide 2 arguments, it will return the part of the string within those indexes;
        System.out.println("Month = " + birthDate.substring(3, 5));

        //  join() allows for multiple strings to be concatenated, and a delimiter to be specified;
        String newDate = String.join("/", "25", "11", "1982");
        System.out.println("newDate = " + newDate);

        //  concat() joins the argument to the string, similar to the + sign;
        newDate = "25".concat("/").concat("11").concat("/").concat("1982");
        System.out.println("newDate = " + newDate);

        //  replace() replaces characters or expressions in a string;
        System.out.println(newDate.replace('/', '-'));
        System.out.println(newDate.replace("2", "00"));

        //  replaceFirst() replaces the first character/expression found;
        System.out.println(newDate.replace("/", "-"));
        //  replaceAll() replaces all, similar to replace();
        System.out.println(newDate.replace("/", "---"));

        //  repeat() repeats the string n times;
        System.out.println("ABC\n".repeat(3));
        System.out.println("-".repeat(20));

        //  indent() adds spaces to the begining of the line;
        System.out.println("ABC\n".repeat(3).indent(8));
        System.out.println("-".repeat(20));
        //  but can also remove them;
        System.out.println("    ABC\n".repeat(3).indent(-2));
        System.out.println("-".repeat(20));

        //  split()
        //  returns a String[] with the pieces of the string split by the regex argument;
        String[] splitStrings = "Hello World again".split(" ");
        for (int i = 0; i < splitStrings.length; i++) {
            System.out.println(splitStrings[i]);
        }

    }

    public static void printInformation(String string) {

        //  length() returns the number of characters in a string;
        int length = string.length();
        System.out.printf("Length = %d %n", length);
        
        //  isEmpty() returns true if length() is 0;
        if (string.isEmpty()) {
            System.out.println("String is Empty");
            return;
        }

        //  isBlank() returns true if length() is 0 OR string only contains whitespace;
        if (string.isBlank()) {
            System.out.println("String is Blank");
            return;
        }
        
        //  charAt() returns character at index n; keep in mind that count starts at index 0;
        System.out.printf("First char = %c %n", string.charAt(0));
        //  to return last character of a string, you must deduct 1 to length() because starts at 0!
        System.out.printf("Last char = %c %n", string.charAt(length - 1 ));

    }

}
