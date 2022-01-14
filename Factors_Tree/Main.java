package Factors_Tree;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // TODO: write your code here for Part 2
    // make new class to return GCF adn another to return LCM
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter two numbers:");
    int a = 0, b = 0;
    try{
      a = scan.nextInt();
      b = scan.nextInt();
    }catch(IllegalArgumentException e){
      System.out.print("not a valid number");
    }
    
    PrimeFactorization factors = new PrimeFactorization(a);

  }
}