// import java.util.Scanner;

// /**
//  *  Class to test Goldbach's Conjecture.
//  *
//  *  Sample methods have been provided for you as a starting point.
//  *  You should, at minimum, implement those methods and the
//  *  main method. You may choose to make these methods static
//  *  (as currently written) or not static.
//  *
//  *  See the description on Classroom for more information.
//  */
// public class Main {
//     /**
//      *  Return a String describing how the given number n can be
//      *  expressed as the sum of primes.
//      *  
//      *  The String should be of the form
//      *     "number = prime1 + prime2"
//      *  where number is equal to n, and prime1 and prime2 are two 
//      *  prime integers that sum to n. The primes can appear in any
//      *  order. 
//      *  If no such primes exist, the method should return null.
//      *  
//      *  Precondition: n is an even integer greater than 2
//      *
//      *  @param n an even integer greater than 2
//      *  @return String describing the prime sum, or null
//      */
//     public static String getPrimeSum(int n) {
//       String answer = "";
//       for(int i = 2; i < Math.sqrt(n); i++){
//         boolean flag = false;
//         for (int j = 2; j < i; j++) {
//           if (i % j == 0) {
//             flag = true;
//             break;
//           }
//         }
//         if (flag == false) {
//           if(testPrime(n - i)){
//             answer = n + " = " + (n - i) + " + " + i;
//           }
//         }
//       }
//       return answer;
//     }
//     public static boolean testPrime(int num){
//       boolean isPrime = false;
//       for(int i = 2; i < (num / 2); i++) {
//         if(num % i == 0){
//           isPrime = true;
          
//           break;
//         }
//       }
//       return isPrime;
//     }
  
//     /**
//      *  Test Goldbach's Conjecture for all even integers greater than
//      *  2 and less than or equal to the specified value.
//      *  
//      *  For integers that pass the test, the method should output
//      *  a single line showing how the integer can be expressed as
//      *  the sum of primes, in the same format as the strings
//      *  returned from the getPrimeSum method.
//      *  
//      *  For integers that fail the test, the method should output
//      *  a line that says "n fails the test", where n is the number.
//      *  If Goldbach is correct, this shouldn't happen.
//      *
//      *  The method should return true if all integers pass,
//      *  and false otherwise.
//      *  
//      *  Precondition: max is greater than 2
//      *
//      *  @param max an integer greater than 2
//      *  @return true if and only if all integers pass
//      */
//     public static boolean testGoldbach(int max) {
//       // TODO: write this method
//       return false;
//     }
  
//     /**
//      * Prompt the user for the maximum integer.
//      * If the integer is 2 or less, display the error message
//      * "Invalid integer" and exit.
//      * Otherwise, use your testGoldbach method to test all integers
//      * up to and including that maximum integer.
//      * If testGoldbach returns false and Goldbach was wrong,
//      * your program should print
//      * "Goldbach's conjecture has been disproven."
//      */
//     public static void main(String[] args) {
//       Scanner scan = new Scanner(System.in);
//       System.out.println("Please input a maximum integer:");
//       int n = scan.nextInt();
//       System.out.println(getPrimeSum(n));

//     }
//   }

  // Java program to implement Goldbach's conjecture
import java.util.*;

public class Main{
	
  static int MAX = 10000;

  // Array to store all prime less
  // than and equal to 10^6
  static ArrayList<Integer> primes = new ArrayList<Integer>();

  // Utility function for Sieve of Sundaram
  static void sieveSundaram()
  {
    // In general Sieve of Sundaram, produces
    // primes smaller than (2*x + 2) for
    // a number given number x. Since
    // we want primes smaller than MAX,
    // we reduce MAX to half This array is
    // used to separate numbers of the form
    // i + j + 2*i*j from others where 1 <= i <= j
    boolean[] marked = new boolean[MAX / 2 + 100];

    // Main logic of Sundaram. Mark all numbers which
    // do not generate prime number by doing 2*i+1
    for (int i = 1; i <= (Math.sqrt(MAX) - 1) / 2; i++)
      for (int j = (i * (i + 1)) << 1; j <= MAX / 2; j = j + 2 * i + 1)
        marked[j] = true;

    // Since 2 is a prime number
    primes.add(2);

    // Print other primes. Remaining primes are of the
    // form 2*i + 1 such that marked[i] is false.
    for (int i = 1; i <= MAX / 2; i++)
      if (marked[i] == false)
        primes.add(2 * i + 1);
  }

  // Function to perform Goldbach's conjecture
  static void findPrimes(int n)
  {
    // Return if number is not even or less than 3
    if (n <= 2 || n % 2 != 0)
    {
      System.out.println("Invalid Input ");
      return;
    }

    // Check only upto half of number
    for (int i = 0 ; primes.get(i) <= n / 2; i++)
    {
      // find difference by subtracting
      // current prime from n
      int diff = n - primes.get(i);

      // Search if the difference is
      // also a prime number
      if (primes.contains(diff))
      {
        // Express as a sum of primes
        System.out.println(primes.get(i) +
              " + " + diff + " = " + n);
        return;
      }
    }
  }

  // Driver code
  public static void main (String[] args)
  {
    // Finding all prime numbers before limit
    sieveSundaram();

    // Express number as a sum of two primes
    findPrimes(4);
    findPrimes(38);
    findPrimes(100);
  }
}

// This code is contributed by mits
