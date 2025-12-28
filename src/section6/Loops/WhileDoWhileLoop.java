package section6.Loops;

public class WhileDoWhileLoop {

    //  WHILE LOOP executes code while the condition is true;
    //  while (CONDITION) {}

    //  DO WHILE executes block once, then only while condition is true;
    //  do {} while (CONDITION);

    //  CONTINUE bypasses all code downstream, and starts new iteration of loop;
    //  BREAK can be used inside IF to break out of loop;

    //  Be wary of NON-STARTER loops !!!
    //  Be wary of ENDLESS LOOPS !!!

    public static void main(String[] args) {
        
        //  for (int i = 1; i <= 5; i++) {
        //      System.out.println(i);
        //  }

        int j = 1;
        boolean isReady = false;

        while (j <= 5) {
            System.out.println(j);
            j++;
        }

        j = 1;
        while (isReady) {
            if (j > 5) {
                break;
            }
            System.out.println(j);
            j++;
        }

        j = 1;
        do {
            if (j > 5) {
                break;
            }
            System.out.println(j);
            j++;
            isReady = (j > 0);
        } while (isReady);

        j = 0;
        while (j < 50) {
            j+=5;
            if (j % 25 == 0) {
                continue;
            }
            System.out.print(j+"_");
        }

    }

}
