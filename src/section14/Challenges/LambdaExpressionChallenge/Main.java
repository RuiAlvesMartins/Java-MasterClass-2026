package section14.Challenges.LambdaExpressionChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        
        String[] palindromes = new String[] {"Anna", "Bob", "Charles", "David", "Eve"};
        System.out.println(Arrays.toString(palindromes));
        System.out.println("-".repeat(30));

        Arrays.setAll(palindromes, (i) -> palindromes[i] = palindromes[i].toUpperCase());
        System.out.println(Arrays.toString(palindromes));
        System.out.println("-".repeat(30));

        List<String> palindromesList = Arrays.asList(palindromes);
        System.out.println(palindromesList);
        palindromesList.replaceAll(string -> string + " " + (char) new Random().nextInt(65, 91) + ".");
        palindromesList.forEach(string -> System.out.println(string));
        System.out.println("-".repeat(30));

        palindromesList.replaceAll(string -> {
            String[] splitString = string.split(" ");
            StringBuilder lastName = new StringBuilder(splitString[0]).reverse();
            return string + " " + lastName.toString().toUpperCase();
        });
        palindromesList.forEach(string -> System.out.println(string));
        System.out.println(Arrays.toString(palindromes));
        System.out.println("-".repeat(30));

        List<String> nonPalindromesList = new ArrayList<>(palindromesList);
        System.out.println(nonPalindromesList);
        nonPalindromesList.removeIf(string -> {
            String[] splitString = string.split(" ");
            return splitString[0].equals(splitString[2]);
        });
        nonPalindromesList.forEach(string -> System.out.println(string));

    }

}
