import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
int eligibleForSell=0;
        int colorCount=0;
         colorCount=0;
        HashMap map= new HashMap();
        for(int i=0;i<n; i++)
        {
            if (map.containsKey(ar[i])!= true)
            {
            	colorCount=1;
            	System.out.println("inside map");
                for(int j=i+1;j<n;j++)
                {
                    if(ar[i] == ar[j])
                    {
                        ++colorCount;
                    }
                }
                map.put(ar[i], Math.abs(colorCount/2));
                eligibleForSell+=colorCount/2;
            }                      
        }
        
        
        System.out.println("eligibleForSell:"+eligibleForSell);
return eligibleForSell;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\ragarwal\\Desktop\\Rajat\\Interview\\Cources\\Eclips\\TestInput.txt"));
        int n = scanner.nextInt();
        
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        System.out.println("arItems "+ arItems.length);
        
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println("result:"+result);

        scanner.close();
    }
}
