
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountVelly {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        
        if (n <=  2)
            return 0;
        
        char stepCounter[]= s.toCharArray();
        int row = stepCounter.length;
        int noOfVallyTraverse=0;
        int hikeCounter=0;
        char startWith=stepCounter[0];
        
        for (int i=0; i<row ; i++)
        {
            if(stepCounter[i] == 'U')
            {
                hikeCounter++;
            }
            else if (stepCounter[i] == 'D')
            {
                hikeCounter--;
            }
            if((hikeCounter == 0)  )
            {
                if(startWith=='D')
                {noOfVallyTraverse+=1;}
                 if (i+1<row)
                {
                    startWith=stepCounter[i+1];
                }
            }
           /* else{
                if (i+1<row)
                {
                    startWith=stepCounter[i+1];
                }
            }*/
            
        }
        
        return noOfVallyTraverse;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println("Result : "+ String.valueOf(result));
       

        scanner.close();
    }
}
