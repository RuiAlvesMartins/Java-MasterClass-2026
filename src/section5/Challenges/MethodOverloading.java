package section5.Challenges;

public class MethodOverloading {
    
    
    
    public static void main(String[] args) {

        System.out.println(convertToCentimeters(10));
        System.out.println(convertToCentimeters(5, 7));

    }

    public static double convertToCentimeters(int heightInches) {
        return heightInches * 2.54;
    }

    public static double convertToCentimeters(int heightFeet, int heightInches) {
        return convertToCentimeters((heightFeet * 12) + heightInches);
    }

}
