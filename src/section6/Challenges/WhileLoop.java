package section6.Challenges;

public class WhileLoop {

    public static void main(String[] args) {
        
        // printEvenNumbers(20, 5);
        // printFiveEvenNumbers(20, 5);

    }

    public static boolean isEvenNumber(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void printEvenNumbers(int n1, int n2) {
        if (n1 > n2) {
            int n3 = n2;
            n2 = n1;
            n1 = n3;
        }
        int i = n1;
        while (i <= n2) {
            if (isEvenNumber(i)) {
                System.out.println(i+" is an even number!");
            }
            i++;
        }
    }

    public static void printFiveEvenNumbers(int n1, int n2) {
        if (n1 > n2) {
            int n3 = n2;
            n2 = n1;
            n1 = n3;
        }
        int i = n1;
        int evenCounter = 0;
        int oddCounter = 0;
        while (i <= n2) {
            if (!isEvenNumber(i)) {
                oddCounter++;
                i++;
                continue;    
            }
            System.out.println(i+" is an even number!");
            evenCounter++;
            i++;
            if (evenCounter == 5) {
                break;
            }
        }
        System.out.println(evenCounter+" even numbers found!");
        System.out.println(oddCounter+" odd numbers found!");
    }

}
