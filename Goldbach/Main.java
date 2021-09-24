import java.util.*;
class Main{
  static ArrayList<Integer> primes = new ArrayList<Integer>();
  static void createPrimeList(int n){
    int MAX = n;
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
  static void createListE(int n){
    boolean prime[] = new boolean[n + 1];
    for (int i = 0; i <= n; i++){
      prime[i] = true;
    }
    for (int p = 2; p * p <= n; p++){
      if (prime[p] == true){
        for (int i = p * p; i <= n; i += p){
          prime[i] = false;
        }
      }
    }
    for (int i = 2; i <= n; i++){
      if (prime[i] == true)
        primes.add(i);
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
          System.out.println("this number does not work");
        }
      }
  }
  public static void main (String[] args) {
    
    Scanner scan = new Scanner(System.in);
    System.out.println("please enter a maximum range:");
    int input = scan.nextInt();
    double start = System.nanoTime();
    createPrimeList(input);
    for(int i = 4; i < input+1; i+=2){
        findPrimes(i);
    }
    double finish = System.nanoTime();
    double timeElapsed = (finish - start) / 1000000000;
    System.out.println("finished in " + timeElapsed + " seconds.");
    scan.close();
  }
}