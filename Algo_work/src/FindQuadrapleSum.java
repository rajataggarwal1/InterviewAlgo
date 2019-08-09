
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class FindQuadrapleSum {

    // find element in array
    static int[] findQuadSum( int[]ar, int sum) {

    	int row = ar.length;    
    	int quad=4;
    	
    	if (row<quad)
    		return new int[0];
    	
    	int returnArr[] = new int[4];
    	
    	HashMap map= new HashMap();
    	int rCounter=0;
		int k=0;
		int total=0;
		
		boolean status=true;
		
    	for(int i=0;i<= row-quad && status; i++)
    		
    		
        {
    		//temp=ar[i];
    		returnArr[rCounter]=ar[i];
    		for (int j=i+1;j< row-quad;j++)
    		{
    			k=j;
    			int loopCount=3;
    			total+=ar[i];
    			rCounter=1;
    			
    			while(loopCount > 0)
    			{
    				total+=ar[k];
    				returnArr[rCounter++]=ar[k++];
    				loopCount--;
    			}
    			
    			if (total==sum)
        		{
    				status=false;
        			break;
        		}
        		else
        		{
        			total=0;
        			rCounter=0;
        			
        			//count++;
        		}
    		}
        }
    	
    	
    	if(status==true)
    	{
    		return new int [0];
    	}
    	else
    	{
    		return returnArr;
    	}
        	
        

    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
    //	 int elementToFind = scanner.nextInt();
         
     //    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      //  int[] ar = {0, 1, 3, 5, 6, 7, 9, 11, 15};
       // int[] ar = {0, 2, 7, 1, 5, 4, 3};
       // int[] ar = {6, 1, 3, 5, 0, 7, 2, 11, 15};
     // int[] ar = {0, 1};
       // int[] ar = {15, 2, 3, 5, 17, 1, 8, 4, 15};
    	 int[] ar = {2, 7, 4, 0, 9, 5, 1, 3};
        int sum=20;
        
        int result []= findQuadSum(ar, sum);
        Arrays.sort(result);
        if(result.length>0)
        {
	        for(int i=0; i<result.length;i++)
	        {
	        	System.out.print(" "+result[i]);
	        }
        }
        else
        {
        	System.out.print(" unable to find");
        }
        	

       // scanner.close();
    }
}
