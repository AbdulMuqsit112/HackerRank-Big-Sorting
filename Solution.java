import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static int partition(String arr[], int low, int high) 
    { 
        String pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            int cal =compare(arr[j],pivot);
            if (cal ==0) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                String temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        String temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
   public static void sort(String arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
  
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    }
    
    static String[] bigSorting(String[] unsorted) 
    {
        
        int n = unsorted.length;
         String [] un = unsorted;
        sort(un,0,n-1);
        return un;

    }
    
    public static int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return 0; // s1 is lee
        }
        else if (s1.length() > s2.length()) 
        {
            return 1;  //s1 is bigger
        }
        for (int i = 0; i < s1.length(); i++) 
        {
            
            if ((int) s1.charAt(i) < (int) s2.charAt(i))
            {
                return 0; //s1[i] is less
            }
            if ((int) s1.charAt(i) > (int) s2.charAt(i))
            {
                return 1;  //s1[i] is bigger
            }

        }
        
        return 2; //equal

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
