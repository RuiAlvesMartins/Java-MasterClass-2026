package section3;

public class Part3OperatorsOperandsExpressions {

    public static void main(String[] args) {
        
        //  OPERATORS, OPERANDS and EXPRESSIONS
        //  this is a single line comment;
        int result = 1 + 2;    // + is the operator, 1 and 2 the operands, 1+2 the expression
        int previousResult = result;
        result = result - 1;
        System.out.println(previousResult);
        System.out.println(result);
        result = result * 10;
        result = result / 4;
        int remainder = 20 % 4;
        remainder = 5 % 3;
        char firstChar = 'A'; char secondChar = 'B';
        System.out.println("" + firstChar + secondChar);



        //  ABREVIATED OPERATORS
        {
        int newResult = 1;
        newResult = newResult + 1;
        System.out.println("result = " + newResult);
        }
        {
        int newResult = 1;
        newResult++;
        System.out.println("result = " + newResult);
        }
        {
        int newResult = 1;
        newResult+=2;
        System.out.println("result = " + newResult);
        }
        {
        int newResult = 1;
        newResult--;
        System.out.println("result = " + newResult);
        }
        {
        int newResult = 1;
        newResult-=2;
        System.out.println("result = " + newResult);
        }
        // lossy conversion
        // x += y
        // x = (data type of x) (x + y)
        {
        int newResult = 10;
        newResult-=5.2;
        System.out.println("result = " + newResult);
        }
        {
        int newResult = 10;
        newResult = (int) (newResult - 5.2);
        System.out.println("result = " + newResult);
        }
        {
        int newResult = 10;
        //  ERROR: cannot convert from double to int!
        // newResult = (double) (newResult - 5.2);                          //  compiler error!
        System.out.println("result = " + newResult);
        }
        {
        double newResult = 10;
        newResult-=5.2;
        System.out.println("result = " + newResult);
        }
        {
        double newResult = 10;
        newResult*=1.5;
        System.out.println("result = " + newResult);
        }
        {
        double newResult = 10;
        newResult/=5;
        System.out.println("result = " + newResult);
        }

    }

}
