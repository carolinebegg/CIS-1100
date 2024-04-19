/*
* Name: Caroline Begg
* Pennkey: cbegg
* Execution: java FingerExercises
*
*
* Program Description: this program executes five different functions using
*                       recursion; the five functions are gcd (finds the greatest
*                       common denominator between two values), log (finds the
*                       number that a log base must be raised to in order to find 
*                       the value of the log), countWaysToClimb (finds the number 
*                       of ways that a set of stairs can be climbed, one by one, two
*                       by two, or a combination of both), sumOfDigits (finds the 
*                       sum of the digits in a number), and sumTo/sumBetween (finds
*                       the sum of all numbers from zero up to a given number and 
*                       finds the sum of all numbers between two given numbers)
*/

public class FingerExercises {
    
    /*
     * Inputs: int a and int b
     * Outputs: greatest common denominator of int a and int b
     * Description: take in two integer input values a and b, return the greatest
     *              common denominator shared by the two ints
    */

    public static int gcd(int a, int b) { //#1
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }
        
        if (a > b) {
            return gcd(a - b, b);
        }
        
        if (b > a) {
            return gcd(a, b - a);
        }
        
        return b;
        
    }

    /*
    * Inputs: int for base of log, int for log 
    * Outputs: int for number that int base must be raised to to find int n
    * Description: take in two integer input values a and b, return the greatest
    *              common denominator shared by the two ints
    */

    public static int log(int base, int n) { //#2
        if (n == 1) {
            return 0;
        }

        return 1 + log(base, n / base);
    }

    /*
    * Inputs: int for the number of stairs
    * Outputs: the number of ways to go up the stairs
    * Description: given an int value for the number of stairs, gives the number of
    *               distinct ways that one could go up the stairs by going 1 at a 
    *               time, 2 at a time, or some combinatin of the two.
    */

    public static int countWaysToClimb(int stairs) { //#3
        
        if (stairs <= 1) {
            return 1;
        }
        
        return countWaysToClimb(stairs - 1) + countWaysToClimb(stairs - 2);
    }

    /*
    * Inputs: int value for a number 
    * Outputs: returns an int  for the sum of all of the digits in the input number
    * Description: takes in an int value, adds together each individual digit in the
    *               number, and returns the sum of the value of all the digits
    */

    public static int sumOfDigits(int x) { //#4
        if (x == 0) {
            return 0;
        }
        return (x % 10) + sumOfDigits(x / 10);
    }

    /*
    * Inputs: two int values a and b
    * Outputs: returns int
    * Description: takes in two int values a and b, adds together all of the numbers
    *              that come between the two values, returns the sum it calculates
    *              numOfVals = b - a, and sum  = a + (a + 1) + (a + 2) ... b
    */

    public static int sumBetween(int a, int b) { //#5
        if (a == b) {
            return b;
        }
        return a + sumBetween(a + 1, b);
    }

    /*
    * Inputs: int value for a number
    * Outputs: int value for the sum of all numbers up to the value of the input
    * Description: adds up all of the numbers from zero to an inputted value, 
    *              outputs the sum of all of the numbers between zero and the value
    *              
    */

    public static int sumTo(int x) { //#5
        if (x == 0) {
            return 0; 
        }
        return sumBetween(1, x);
    }

    public static void main(String[] args) {

    }
}
