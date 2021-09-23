import java.util.*;
class Main{
  static int MAX = 100000000;
  static ArrayList<Integer> primes = new ArrayList<Integer>();
  static void createPrimeList(){
    boolean[] marked = new boolean[(MAX / 2 + 100)];
    for (int i = 1; i <= (Math.sqrt(MAX) - 1) / 2; i++){
      for (int j = (i * (i + 1)) << 1; j <= MAX / 2; j = j + 2 * i + 1){
        marked[j] = true;
      }  
    }
    primes.add(2);
    for (int i = 1; i <= MAX / 2; i++){
      if (marked[i] == false){
        primes.add(2 * i + 1);
      }
    }
      
  }
  static void findPrimes(int n){
      String answer;
      if (n <= 2 || n % 2 != 0){
        System.out.println("Invalid Integer");
        return;
      }
      for (int i = 0 ; primes.get(i) <= n / 2; i++){
        int diff = n - primes.get(i);
        if (primes.contains(diff)){
          answer = n +  " = " + diff + " + " + primes.get(i);
          //System.out.println(answer);
          return;
        }else if( n % 2 != 0){
          //System.out.println("this number does not work");
        }
      }
  }
  public static void main (String[] args) {
    createPrimeList();
    Scanner scan = new Scanner(System.in);
    System.out.println("please enter a maximum range:");
    int input = scan.nextInt();
    double start = System.nanoTime();
    for(int i = 3; i < input+1; i++){
      if(i % 2 == 0){
        findPrimes(i);
      }
    }
    double finish = System.nanoTime();
    double timeElapsed = (finish - start) / 1000000000;
    System.out.println("finished in " + timeElapsed + " seconds.");
    scan.close();
  }
}
