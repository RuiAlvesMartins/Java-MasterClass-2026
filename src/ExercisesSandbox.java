import java.util.Scanner;

public class ExercisesSandbox {

    public static void main(String[] args) {
        // System.out.println(toMilesPerHour(1.5));
        // System.out.println(toMilesPerHour(10.25));
        // System.out.println(toMilesPerHour(-5.6));
        // System.out.println(toMilesPerHour(25.42));
        // System.out.println(toMilesPerHour(75.114));

        // System.out.println(areEqualByThreeDecimalPlaces(-123.456, -123.456));

        // System.out.println(getDaysInMonth(2016, 2));

        // System.out.println(sumFirstAndLastDigit(5));

        // System.out.println(getDigitCount(123456));

        // System.out.println(reverse(123456));

        // numberToWords(123456);


        // System.out.println(getLargestPrime(21) == 7);
        // System.out.println(getLargestPrime(217) == 31);
        // System.out.println(getLargestPrime(0) == -1);
        // System.out.println(getLargestPrime(45) == 5);
        // System.out.println(getLargestPrime(-1) == -1);
        // System.out.println(getLargestPrime(7) == 7);
        // System.out.println(getLargestPrime(2) == 2);
        // System.out.println(getLargestPrime(16) == 2);
        // System.out.println(getLargestPrime(16));

        // printSquareStar(1000);

        // inputThenPrintSumAndAverage();

        System.out.println(getBucketCount(-3.4,2.1, 1.5, 2) == -1);
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2) == 3);
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1) == 3);
        System.out.println(getBucketCount(-3.4, 2.1, 1.5) == -1);
        System.out.println(getBucketCount(3.4, 2.1, 1.5) == 5);
        System.out.println(getBucketCount(7.25, 4.3, 2.35) == 14);
        System.out.println(getBucketCount(3.4, 1.5) == 3);
        System.out.println(getBucketCount(6.26, 2.2) == 3);
        System.out.println(getBucketCount(3.26, 0.75) == 5);

    }

    public static long toMilesPerHour(double kilometersPerHour) {

        return kilometersPerHour < 0 ? -1L : Math.round(kilometersPerHour/1.609344);
        
    }

    public static boolean areEqualByThreeDecimalPlaces(double n1, double n2) {
        
        long units1 = (long) (n1 * 1000D);
        long units2 = (long) (n2 * 1000D);
        
        return units1 == units2;
        
    }

    public static int getDaysInMonth(int year, int month) {
        if (year < 1 || year > 9999) {
            return -1;
        }
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                yield isLeapYear(year) ? 29 : 28;
            }
            default -> -1;
        };
        
    }

    public static boolean isLeapYear(int year) {
        
        boolean isLeapYear = false;
        
        boolean validYear = false;
        if (year >= 1 && year <= 9999) {
            validYear = true;
        }
        
        if (validYear) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeapYear = true;
                    }
                } else {
                    isLeapYear = true;
                }
            }
        }
        
        return isLeapYear;
        
    }

    public static int sumFirstAndLastDigit(int number) {
        
        if (number < 0) {
            System.out.println("Invalid input!");
            return -1;
        }
        
        int dividend = number;
        int digit = 0;
        int digitSum = 0;
        int iterator = 0;
        
        while (dividend > 0) {
            digit = dividend % 10;
            dividend/=10;
            iterator++;
            if (iterator == 1) {
                digitSum+=digit;
            }
        }
        
        digitSum+=digit;
        return digitSum;
        
    }

    public static int getDigitCount(int number) {
    
        if (number < 0) {
            System.out.println("Invalid input!");
            return -1;
        }
        
        int dividend = number;
        int digitCount = 0;
        
        do {
            dividend/=10;
            digitCount++;
        } while (dividend > 0);
        
        return digitCount;
        
    }

    public static int reverse(int number) {
        
        boolean isNegative = number < 0;
        int dividend = Math.abs(number);
        int digit = 0;
        int reverse = 0;
        
        while (dividend > 0) {
            
            digit = dividend % 10;
            dividend/=10;
            reverse = (reverse * 10) + digit;
            
        }
        
        return isNegative ? -reverse : reverse;
        
    }
    
    public static void numberToWords(int number) {
        
        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }
        
        int reversedNumber = reverse(number);
        int dividend = reversedNumber;
        int digit = 0;
        int leadingZeros = getDigitCount(number) - getDigitCount(reversedNumber);
        String digitString = "";
        
        do {
            
            digit = dividend % 10;
            dividend/=10;
            
            digitString = switch (digit) {
                case 0 -> "Zero";
                case 1 -> "One";
                case 2 -> "Two";
                case 3 -> "Three";
                case 4 -> "Four";
                case 5 -> "Five";
                case 6 -> "Six";
                case 7 -> "Seven";
                case 8 -> "Eight";
                case 9 -> "Nine";
                default -> "oh no";
            };
            
            System.out.println(digitString);

        } while (dividend > 0);
        
        for (int i = 1; i <= leadingZeros; i++) {
            System.out.println("Zero");
        }

    }

    public static int getLargestPrime(int number) {
        
        if (number < 0) {
            System.out.println("Invalid input!");
            return -1;
        }

        if (number == 2) {
            return 2;
        }
        
        int divisor = 0;
        boolean isPrime = false;
        
        for (int i = 1; i < number; i++) {

            if (isPrime) {
                break;
            }
            
            if (number % i == 0) {      // i is a divisor
                
                divisor = number / i;

                if (divisor == 2) {
                    return divisor;
                }
                
                for (int j = 2; j < divisor; j++) {
                    if (divisor % j == 0) {
                        break;
                    }
                    if (j == divisor - 1) {
                        isPrime = true;
                    }

                }
                
            }
            
        }

        return isPrime ? divisor : -1;
        
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            System.out.println("Invalid input!");
            return false;
        }
        
        if (goal % 5 == 0) {
            return true;
        }

        int smallBagsNeeded = goal - bigCount * 5;
        
        if (smallBagsNeeded >= 0) {
            return smallCount >= smallBagsNeeded;
        }
        
        if (smallBagsNeeded < 0) {
            smallBagsNeeded = Math.abs(smallBagsNeeded % 5);
            return smallCount >= (5 - smallBagsNeeded);
        }

        return false;

    }
    
    public static boolean isPrimeNumber(int n) {
        if (n <= 0) {
            System.out.println(n + " is not a valid input! Whole number must be positive!");
            return false;
        }

        if (n <= 2) {return true;}
        
        for (int i = 2; i <= (n/2); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int getLargestPrime2(int number) {
        
        if (number < 0) {
            System.out.println("Invalid input!");
            return -1;
        }

        int divisor;
        
        for (int i = 1; i < number; i++) {
            
            if (number % i == 0) {      
                
                divisor = number / i;

                if (isPrimeNumber(divisor)) {
                    return divisor;
                }
                
            }
            
        }

        return -1;
    }

    public static int getLargestPrime3(int number) {
        
        if (number < 2) {
            return -1;
        }
 
        int factor = -1;
        for (int i = 2; i * i <= number; i++) {
            if (number % i != 0) {
                continue;
            }
            factor = i;
            while (number % i == 0) {
                number /= i;
            }
        }
        return number == 1 ? factor : number;
    }

    public static void printSquareStar(int number) {
        
        if (number < 5) {
            System.out.println("Invalid Value");
            return;
        }
        
        int row = 1;
        int column = 1;
        
        while (row <= number) {
        //  ROWS
            
            while (column <= number) {
            //  COLUMNS
                
                if (row == 1 || row == number) {
                    System.out.print("*");
                    column++;
                    continue;
                }
                
                if (column == 1 || column == number) {
                    System.out.print("*");
                    column++;
                    continue;
                }
                
                if (column == row) {
                    System.out.print("*");
                    column++;
                    continue;
                }
                
                if (column == number - row + 1) {
                    System.out.print("*");
                    column++;
                    continue;
                }
                
                System.out.print(" ");
                column++;
            
            }
            
            System.out.println();
            row++;
            column = 1;
            
        }
        
    }

    public static void inputThenPrintSumAndAverage() {
        // System.out.println("INTEGER SUM & AVERAGE");

        Scanner scanner = new Scanner(System.in);
        String stringInput = "";
        int parsedInput = 0;
        int countInput = 0;
        int sumInput = 0;
        double avgDouble = 0D;
        boolean validInput = true;

        do {
            // System.out.println("Please input a valid integer:");
            // System.out.println("(or type a non-numeric character to exit program)");
            
            stringInput = scanner.nextLine();

            try {

                parsedInput = Integer.parseInt(stringInput);
                sumInput+=parsedInput;
                countInput++;
                avgDouble = (double) sumInput / countInput;
                // System.out.println(parsedInput+" read as integer");

            } catch (NumberFormatException e) {
                validInput = false;
                // System.out.println(stringInput+" not read as integer");
                // System.out.println("Invalid input, program closing...");
            }

        } while (validInput);

        long avgLong = Math.round(avgDouble);

        System.out.println("SUM = "+sumInput+" AVG = "+avgLong);
        // System.out.println("PROGRAM EXIT");

    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBucket) {

        boolean validWidth = width > 0;
        boolean validHeight = height > 0;
        boolean validAreaBucket = areaPerBucket > 0;
        boolean validExtraBucket = extraBucket >= 0;

        if (!validWidth || !validHeight || !validAreaBucket || !validExtraBucket) {
            return -1;
        }

        double areaToBePainted = width * height;
        double bucketsNeeded = areaToBePainted / areaPerBucket;
        bucketsNeeded = Math.ceil(bucketsNeeded);
        int bucketsToBuy = (int) bucketsNeeded - extraBucket;

        return bucketsToBuy;

    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {

        return getBucketCount(width, height, areaPerBucket, 0);

    }

    public static int getBucketCount(double area, double areaPerBucket) {

        return getBucketCount(area, 1, areaPerBucket, 0);

    }

}
