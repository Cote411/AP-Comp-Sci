package Factors_Tree;

public class PrimeFactorization {
    private int numberToFactor;
    private int[] factors = new int[]{};
    public PrimeFactorization(int posNum){
      if(posNum <= 0){
        throw new IllegalArgumentException(); 
      }
      numberToFactor = posNum;
      factorNumber(posNum);
    }
    public int getNumber(){
      return numberToFactor;
    }
    public void factorNumber(int a){
      //TODO: put prime factorization in the array factors
      
    }
    public int getFactorCount(){
      //TODO: return factors.length
      return factors.length;
    }
    public int getFactor(int n){
      //TODO: return factor[n]
      return factors[n];
    }
  }
