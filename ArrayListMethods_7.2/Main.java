import java.util.ArrayList;
import java.util.Scanner;

class Main {


    public static void printPartitions(ArrayList<Integer> list) {
        // print all possible partitions for given positive integer n
        for(int i = list.size() - 1; i >= 0; i--){
            if(i == 0)
                System.out.print(list.get(i));
            else
                System.out.print(list.get(i) + "+");
        }
        System.out.println();
        
    }

    public static void displayPartitions(int sumLeft, int max, ArrayList<Integer> list) {
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
        if(sumLeft == 0){
            printPartitions(list);
            return;
        }
        for (int i = max; i >= 1; i--){
            if (i > sumLeft){
                continue;
            }else if (i <= sumLeft){
                list.add(i);
                displayPartitions(sumLeft - i, i, list);
            }
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("Please enter a number:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        displayPartitions(n, n, list);
        scan.close();
        // prompt the user for an integer
        // print partitions for that integer
    }
}