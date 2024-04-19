import static org.junit.Assert.*;
import org.junit.*;

public class FingerExercisesStudentTests {
  /**
   * This is where you will write your test cases.
   */

   //test for GCD function
   @Test
   public void TestGCDWhenAIsZero() {
     int expected = 5;
     int actual = FingerExercises.gcd(0, 5);
     assertEquals("gcd of 0 and 5", expected, actual);
   }

   //test for sum between function
   @Test
   public void TestSumBetweenZeroAndZero() {
     int expected = 0;
     int actual = FingerExercises.sumBetween(0, 0);
     assertEquals("sum between 0 and 0", expected, actual);
   }

   //test for sumn of digits function
   @Test
   public void TestSumOfDigitsOfOneZeroOneZero() {
     int expected = 3;
     int actual = FingerExercises.sumOfDigits(10101);
     assertEquals("sum of digits of 10101", expected, actual);
   }

   //test for climb stairs function
   @Test
   public void TestSixStairs() {
     int expected = 13;
     int actual = FingerExercises.countWaysToClimb(6);
     assertEquals("ways to climb 6 stairs", expected, actual);
   }


   //test for log function
   @Test
   public void TestForLogBaseFourOfSeventy() {
     int expected = 3;
     int actual = FingerExercises.log(4, 70);
     assertEquals("log base 4 of 70", expected, actual);
   }

   //test for sum to function
   @Test
   public void TestForSumToTwentyOne() {
     int expected = 231;
     int actual = FingerExercises.sumTo(21);
     assertEquals("sum to 21", expected, actual);
   }

   // This is for compilation purposes
   @Test
   public void TestIgnoreThis() {
     assertTrue(true);
   }
}
