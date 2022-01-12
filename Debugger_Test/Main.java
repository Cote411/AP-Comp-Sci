import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
  public static boolean isPrime(int n){
    for(int i = 2; i < n/2; i++){
      if(n % i == 0){
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter two numbers:");
    int a = 0, b = 0;
    try{
      a = scan.nextInt();
      b = scan.nextInt();
    }catch(InputMismatchException e){
      System.out.println();
      return;
    }
    int start = 0, end = 0;
    if(a > b){
      start = b;
      end = a;
    }else{
      start = a;
      end = b;
    }
    for(int i = start; i <= end; i++){
      if(isPrime(i)){
        System.out.print(i + " ");
      }
    }
  }
}