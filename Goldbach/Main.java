import java.util.Scanner;

/**
 *  Class to test Goldbach's Conjecture.
 *
 *  Sample methods have been provided for you as a starting point.
 *  You should, at minimum, implement those methods and the
 *  main method. You may choose to make these methods static
 *  (as currently written) or not static.
 *
 *  See the description on Classroom for more information.
 */
public class Main {
    /**
     *  Return a String describing how the given number n can be
     *  expressed as the sum of primes.
     *  
     *  The String should be of the form
     *     "number = prime1 + prime2"
     *  where number is equal to n, and prime1 and prime2 are two 
     *  prime integers that sum to n. The primes can appear in any
     *  order. 
     *  If no such primes exist, the method should return null.
     *  
     *  Precondition: n is an even integer greater than 2
     *
     *  @param n an even integer greater than 2
     *  @return String describing the prime sum, or null
     */
    public static String getPrimeSum(int n) {
      String answer = "";
      for(int i = 2; i < Math.sqrt(n); i++){
        boolean flag = false;
        for (int j = 2; j < i; j++) {
          if (i % j == 0) {
            flag = true;
            break;
          }
        }
        if (flag == false) {
          if(testPrime(n - i)){
            answer = n + " = " + (n - i) + " + " + i;
          }
        }
      }
      return answer;
    }
    public static boolean testPrime(int num){
      boolean isPrime = false;
      for(int i = 2; i < (num / 2); i++) {
        if(num % i == 0){
          isPrime = true;
          
          break;
        }
      }
      return isPrime;
    }
  
    /**
     *  Test Goldbach's Conjecture for all even integers greater than
     *  2 and less than or equal to the specified value.
     *  
     *  For integers that pass the test, the method should output
     *  a single line showing how the integer can be expressed as
     *  the sum of primes, in the same format as the strings
     *  returned from the getPrimeSum method.
     *  
     *  For integers that fail the test, the method should output
     *  a line that says "n fails the test", where n is the number.
     *  If Goldbach is correct, this shouldn't happen.
     *
     *  The method should return true if all integers pass,
     *  and false otherwise.
     *  
     *  Precondition: max is greater than 2
     *
     *  @param max an integer greater than 2
     *  @return true if and only if all integers pass
     */
    public static boolean testGoldbach(int max) {
      // TODO: write this method
      return false;
    }
  
    /**
     * Prompt the user for the maximum integer.
     * If the integer is 2 or less, display the error message
     * "Invalid integer" and exit.
     * Otherwise, use your testGoldbach method to test all integers
     * up to and including that maximum integer.
     * If testGoldbach returns false and Goldbach was wrong,
     * your program should print
     * "Goldbach's conjecture has been disproven."
     */
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Please input a maximum integer:");
      int n = scan.nextInt();
      System.out.println(getPrimeSum(n));

    }
  }