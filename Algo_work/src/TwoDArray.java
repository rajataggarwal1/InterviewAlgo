
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoDArray {

    // find element in array
    static boolean findElementInArray(int elementToFind , int[][]ar) {

    	int row = ar.length;
    	int col = ar[0].length;
    	int tempLocation=-1;
    	boolean elementExist = false;
    	
    	for(int i=0;i<row; i++)
        {
    		if (elementToFind <=  ar[i][col-1])
    		{
    			tempLocation = i;
    			break;
    		}
        }
    	
    	
    			
    	
        if (tempLocation == -1)
        {
        	return false;
        }
        else
        {
        	for(int i=0;i<col; i++)
            {
        		if (ar[tempLocation][i] == elementToFind)
        		{
        			elementExist=true;
        			break;
        		}
            }
        	return elementExist;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
    	 int elementToFind = scanner.nextInt();
         
         scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] ar = {
            {1, 3, 5, 6},
            {7, 9, 11, 15},
            {17, 50, 75, 89}
        };
        
        
        boolean result = findElementInArray(elementToFind, ar);
        System.out.println("result:"+result);

        scanner.close();
    }
}
