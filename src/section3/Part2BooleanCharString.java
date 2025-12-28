package section3;

public class Part2BooleanCharString {

    public static void main(String[] args) {
        
        //  CHAR and BOOLEAN
        //  Unicode can represent all characters specific to different languages;
        //  https://symbl.cc/en/unicode-table/
        char myChar = 'D';
        //  chars may only contain one character!
        // char myChar = 'DD';                                              //  compiler error!
        char myUnicodeChar = '\u0044';
        char myDecimalCode = 68;
        char simpleChar = '?', unicodeChar = '\u003F', decimalChar = 63;
        System.out.println("A Character occupies " + Character.SIZE + " bits of memory.");
        boolean isTrue = true;
        boolean isFalse = false;
        //  a boolean has no size method!
        // System.out.println("A Boolean occupies " + Boolean.SIZE + " bits of memory.");         //  compiler error!



        //  STRING
        //  String is NOT a PRIMITIVE data type!
        //  Strings are IMMUTABLE!
        String myString = "This is a string";
        myString = myString + ", and this is more.";
        System.out.println("myString is equal to " + myString);
        myString = "I wish I had \u00241,000,000.00";
        //  Multiple lines in java {}
        {
        String numberString = "250.55";
        numberString = numberString + "49.45";
        System.out.println(numberString);
        }
        String numberString = "250.55"; numberString = numberString + "49.45"; System.out.println(numberString);
        //  CONCATENATION in strings
        // int myInt = "10";                                                //  compiler error!
        String lastString = "10"; int myInt = 50;
        lastString = lastString + myInt;
        double doubleNumber = 120.47; lastString = lastString + doubleNumber;

    }

}
