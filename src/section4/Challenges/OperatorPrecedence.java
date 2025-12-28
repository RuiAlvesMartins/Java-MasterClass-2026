package section4.Challenges;

public class OperatorPrecedence {

    //  https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html
    //  https://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html

    public static void main(String[] args) {
        
        double d1 = 20D;
        double d2 = 80D;
        double d3 = ((d1 + d2) * 100) % 40D;

        boolean remainderZero = (((d1 + d2) * 100) % 40D) == 0D ? true : false;
        System.out.println(remainderZero);

        if (!remainderZero) {
            System.out.println(d3 + " remaining!");
        }

        //  System.out.println(d3);
        //  System.out.println(d4);

    }

}
