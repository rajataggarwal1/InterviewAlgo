package com.leetcode;


import java.io.*;
import java.util.*;
import java.util.regex.*;

public class IntegerReplacement {

	
	ArrayList arr= new ArrayList();
	
    // find element in array
    static int intReplacmentCount( int no) {
    	int count1=0;
        int count2=0;
        int temp2=no;
    	if (no==1)
            return count1;
        
    	do{
    		
    		if( (no%2) != 0 )
    		{
    			if(no!=3)
    			{
    			count1++;
    			}
    			no=no-1;
    			
    		}
    		no=no/2;
    		count1++;
    		
    	}while(no != 1);
    	
    	
    	    	do{
    		
    		if( ((temp2%2) != 0) && (temp2!=3))
    		{
    			temp2=temp2+1;
    			
    			count2++;
    		}
    		temp2=temp2/2;
    		count2++;
    		
    	}while(temp2 != 1);

    	    	System.out.println("Count1 : "+count1);
    	    	System.out.println("Count2 : "+count2);
    	    	
        if(count1>count2)
        {
            return count2;
        }
        else
        {
            return count1;
        }
    	
    }
    
      
    public static void main(String[] args) throws IOException {
        
        
        int noOfstepsToreplace;
      //  noOfstepsToreplace=intReplacmentCount(5);
        
      //  System.out.println("result:"+noOfstepsToreplace);
        
      //  noOfstepsToreplace=intReplacmentCount(8);
        
     //   System.out.println("result:"+noOfstepsToreplace);
        
 //noOfstepsToreplace=intReplacmentCount(65535);
// noOfstepsToreplace=intReplacmentCount(10000);
        noOfstepsToreplace=intReplacmentCount(10000);
        System.out.println("result:"+noOfstepsToreplace);
        
        
    }
}
