package section6.ExceptionHandlingAndUserInput;

public class ParsingValues {

    //  PARSING means converting a string into an appropriate data type, usually a primitive;
    //  CASTING is different;

    public static void main(String[] args) {

        int currentYear = 2022;
        String usersDateOfBirth = "1999";

        int dateOfBirth = Integer.parseInt(usersDateOfBirth);

        System.out.println("Age = " + (currentYear - dateOfBirth));

        String usersAgeWithPartialYear = "22.5";
        double ageWithPartialYear = Double.parseDouble(usersAgeWithPartialYear);
        System.out.println("The user says he's " + ageWithPartialYear);

    }
    
}
