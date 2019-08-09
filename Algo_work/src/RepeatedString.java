import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {
	static long repeatedString(String s, long n) {

        char arr[]=s.toCharArray();
        int stringSize= s.length();
        long noOfPair=(long) (n/stringSize);
            long noOfRemainingchar= (long)n%stringSize;
        long count=0;
        int modcount=0;
        
        for(int i=0,j=0;i< arr.length; i++,j++)
        {
            if (arr[i]=='a')
            {
                count++; 
                if (j<noOfRemainingchar)
                {
                    modcount++;
                }
                
            }
            
        }
        
        if (noOfPair > 0)
        {
            count= (count*noOfPair)+ modcount;
        }
        else
        {
        	count=modcount;
        }
        
        
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        
        System.out.println("result:"+result);


      //  bufferedWriter.write(String.valueOf(result));
    //    bufferedWriter.newLine();

    //    bufferedWriter.close();

        scanner.close();
    }
}
