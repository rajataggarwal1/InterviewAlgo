
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingClouds {

    // Complete the countingValleys function below.
	static int jumpingOnClouds(int[] c) {

        int row= c.length;
        int noOfJump=0;
        int count=0;
        int similarVal=0;
          int innerLoopCount=0;  
        if (row < 2)
            return noOfJump;
        
        for(int i=0; i< row-1; i+=innerLoopCount)
        {
            similarVal= c[i];
            innerLoopCount=0;
            if(c[i]==0)
            {   
                count++;
            }
            else
            {
                noOfJump++;
            }
            
            for (int j=i+1; j< row ;++j)
            {
            	innerLoopCount++;
                if (similarVal== c[j])
                {
                    count++;
                    //continue;
                }
                if (similarVal != c[j] || j==row-1)
                {
                  /* if( count ==1)
                   {noOfJump+=1;}
                   else*/
                   noOfJump+= Math.abs(count/2);
                	
                   // i+=count;
                    count=0;
                    break;
                    
                }
                
            }
            
        }
        
        return noOfJump;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       // int n = scanner.nextInt();
       // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       // String s = scanner.nextLine();
       // int[] ar = {0, 0,0,0,0,0,0, 1,0,0,0, 0, 1, 0}; //
       //  int[] ar = {0, 0, 0, 0, 1, 0}; //3
       //  int[] ar = {0, 0, 0, 1, 0}; //2
         int[] ar = {0, 1,0,0,1,0,1,0}; //4
     //   int[] ar = {0, 0, 0, 1, 0, 0}; //3
      // int[] ar = {0, 1, 0, 0}; //2
       // int[] ar = {0, 1, 0, 1,0,1,0}; //3
    //	int[] ar = {0,0}; //1
        
        int result = jumpingOnClouds(ar);

        System.out.println("Result : "+ String.valueOf(result));
       

        scanner.close();
    }
}
