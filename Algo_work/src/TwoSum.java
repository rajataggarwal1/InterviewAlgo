
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class TwoSum {

	
	ArrayList arr= new ArrayList();
	
    // find element in array
    static int[] findTwoSum( int[]ar, int target) {

    	int row = ar.length;    	
    	int secondnoTofind=0 ;
    	int returnArray[]= new int[2];
    	
    	   	
    	for(int i=0;i<row; i++)
        {
    		int numberTofind= ar[i] - target;
    		
    		if(numberTofind > 0)
    			continue;
    		else    		
    		{
    			secondnoTofind= target - ar[i];
    			returnArray[0]= i;
    			  			
    		}
        			
    			for(int j=i+1;j<row; j++)
    			{
    				if(ar[j]==secondnoTofind)
    				{
    					returnArray[1]= j;
    					i=row;
    					break;
    				}
    				
    			}
    			
    			
    		}
        
          	
        
        	return returnArray;
        

    }
    
    
     void AddNum (int num) 
    	{
    		arr.add(num);
    	}
    	
    	 boolean findSum(int target)
    		{
    		 
    		 Iterator itr= arr.iterator();
    		 
    		 HashMap map= new HashMap();
    		 
    		 int valToFind=0;
    		 
    		 while(itr.hasNext())
    		 {
    			 int val=(Integer)itr.next();;
    			 valToFind= target - val;
    			 if(map.containsKey(valToFind) == true)
    			 {
    				 return true;
    			 }
    			 
    			 map.put(val,val);
    		 }
    		 
    		 
    		 
    			return false;
    		}
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
    	
    //------Start ----------For findTwoSum	
  /*  	int elementToFind = scanner.nextInt();
         
     //    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      //  int[] ar = {0, 1, 3, 5, 6, 7, 9, 11, 15};
       // int[] ar = {-1,-2,-3,-4,-5};
        int[] ar = {6, 1, 3, 5, 0, 7, 2, 11, 15};
       // int[] ar = {11, 1,6,3};
        int[] ar = {2, 7, 11, 15};
        
        
        int result[] = findTwoSum(ar, elementToFind);
        System.out.println("result:"+result[0]+ "  - "+result[1]);
               

        scanner.close();*/
        //----------------------end------------
        
        TwoSum ts=new TwoSum();
        
        ts.AddNum(1);
        ts.AddNum(3);
        ts.AddNum(5);

        System.out.println("result:"+ts.findSum(4));
        System.out.println("result:"+ts.findSum(7));
        
        
        
    }
}
