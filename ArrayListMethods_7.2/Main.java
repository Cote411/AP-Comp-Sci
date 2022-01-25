import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void printPartitions(int n) {
    // print all possible partitions for given positive integer n
  }

  public static void displayPartitions(int n, ArrayList<Integer> list) {
    // recursive helper function
    // If the sum of the values in list is n:
    //    just print these values.
    // If the sum is less than n:
    //    try appending to the list another integer,
    //    in the range from the last value in the list
    //    (or 1, if the list was empty) to n - sum,
    //    and call displayPartitions(n, list) again.
    //    Don't forget to remove the last added value before
    //    trying the next one.
  }
  
  public static void main(String[] args) {
    System.out.println("Hello world!");
    // prompt the user for an integer
    // print partitions for that integer
  }
}