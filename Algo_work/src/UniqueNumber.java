
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class UniqueNumber {

    // find element in array
    static int findUniqueElementInArray( int[]ar) {

    	int row = ar.length;    	
    	int elementExist=0 ;
    	
    	HashMap map= new HashMap();
    	
    	for(int i=0;i<row; i++)
        {
    		//elementExist= ar[i]+1;
    		if( ar[i] > elementExist)
    		{
    			
    			map.put(ar[i],ar[i]);
    			continue;
    		}
    		else 
    		{
    			if (ar[i] == elementExist)
    			{
    				map.put(ar[i],ar[i]);
    				elementExist += 1;
        			for (int j=0; j< map.size(); j++)
        			{
        				if(map.containsKey(elementExist))
        					elementExist += 1;
        			}
    				
    				
    			}
    			
    		}
        }
    	
    	
    			
    	
        
        	return elementExist;
        

    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
    //	 int elementToFind = scanner.nextInt();
         
     //    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      //  int[] ar = {0, 1, 3, 5, 6, 7, 9, 11, 15};
        int[] ar = {0, 2, 7, 1, 5, 4, 3};
       // int[] ar = {6, 1, 3, 5, 0, 7, 2, 11, 15};
      // int[] ar = {0, 1};
     //   int[] ar = {15, 2, 3, 5, 17, 1, 8, 4, 15};
        
        int result = findUniqueElementInArray(ar);
        System.out.println("result:"+result);

       // scanner.close();
    }
}
