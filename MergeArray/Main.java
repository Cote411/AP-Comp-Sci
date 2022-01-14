package MergeArray;
import java.util.*;
public class Main {
      public static String[] mergeArrays(String[] inArray1, String[] inArray2) {
    //     List<String> list = new ArrayList<String>();
        for(int i = 0; i < inArray1.length; i++) {
            inArray1[i] = toTitleCase(inArray1[i]);
        }
        for(int i = 0; i < inArray2.length; i++) {
            inArray2[i] = toTitleCase(inArray2[i]);
        }
    //     for(int i = 0; i < inArray1.length; i++){
    //       for(int j = 0; j < inArray2.length; j++){
    //         if(inArray1[i].charAt(0) < inArray2[j].charAt(0)){
    //           list.add(inArray2[j]);
    //         }else{
    //           list.add(inArray1[i]);
    //           break;
    //         }
    //       }
    //     }
    //     String[] arr = new String[list.size()];
    //     arr = list.toArray(arr);
    //     return arr;
        String[] answer = new String[inArray1.length + inArray2.length];
        int i = 0, j = 0, k = 0;

        while (i < inArray1.length && j < inArray2.length)  
            answer[k++] = inArray1[i].compareToIgnoreCase(inArray2[j]) < 0 ? inArray1[i++] :  inArray2[j++];

        while (i < inArray1.length)  
            answer[k++] = inArray1[i++];

        while (j < inArray2.length)    
            answer[k++] = inArray2[j++];

        return answer;
      }
    
    //   public static String[] toStringArray(String c){
    //     //String[] returnString = new String[];
    //     return null;
    //   }
    
      public static String toTitleCase(String input) {
        StringBuilder stringToTitleCase = new StringBuilder(input.length());
        boolean flag = true;
    
        for (char c : input.toCharArray()) {
          c = Character.toLowerCase(c);
          if (Character.isSpaceChar(c)) {
            flag = true;
          } else if (flag) {
            c = Character.toTitleCase(c);
            flag = false;
          }
          stringToTitleCase.append(c);
        }
    
        return stringToTitleCase.toString();

       

      }
     
      public static void main(String[] args) {
        String[] array1 = { "EIGHT", "five", "fOUR", "nInE", "One", "SeVeN", "six", "TEN", "tHRee", "TWo" };
        String[] array2 = { "Array", "BE", "each", "GUARANTEED", "InPUt", "iS", "sOrTeD", "to" };
    
        System.out.println("Input arrays:");
        printArray(array1);
        System.out.println();
        System.out.println();
        printArray(array2);
        System.out.println();
        System.out.println();
        System.out.println("Merged array:");
        printArray(mergeArrays(array1, array2));
        
      }
    
      public static <T> void printArray(T[] a) {
        if (a != null) {
          for (int i = 0; i < a.length; i++) {
            if (i != 0)
              System.out.print(", ");
            System.out.print(a[i]);
          }
        }
      }
    }  
