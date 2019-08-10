package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 739. Daily Temperatures
Medium

https://leetcode.com/problems/daily-temperatures/

Share
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 * 
 * 
 */
public class DailyTemperatures739 {
	public int[] dailyTemperatures(int[] T) {
        // This is brut force solution having two loops to cheeck the value and populate the result array
        // Another O(n) solution will be go in one pass from last elemet to first and keep pushing value in stack and check and pop
        if(T.length ==1)
        {
            return new int[]{0};
        }
                  
        int[] returnArray=new int[T.length];
        int k=0;
        
        for(int i=0; i< T.length; i++)
        {
            boolean notfound=false;
            for(int j=i+1; j< T.length; j++)
            {
                if(T[j] > T[i])
                {
                    returnArray[k++]=j-i;
                    notfound=true;
                    break;
                }
                else
                {
                    continue;
                }
            }
            if(notfound==false)
            {
                k++;
            }
            
        }
        
     
        
     return returnArray;   
        
    }
	
	
	/*
	 * Need to complete below solution for which i am using map 
	 */
public int[] dailyTemperatures_map(int[] T) {
        
        if(T.length ==1)
        {
            return new int[]{0};
        }
        
        Map<Integer, Integer> tempMap= new HashMap<Integer, Integer>();
        
        int[] returnArray=new int[T.length];
        
        for(int i=0; i< T.length; i++)
        {
            tempMap.put(i,T[i]);            
            
        }
        
        int j=0;
        int count=0;
        for(int i=0; i< T.length; i++)
        {
            int tempTocheck=T[i]+1;
            
            while(tempTocheck <=100 )
            {       
                    if(tempMap.containsValue(tempTocheck)==true)
                    {
                       int index= tempMap.get(tempTocheck);// this is wrong, I want to takeout key
                        returnArray[j++]= index-i;
                    }
                
                tempTocheck++;              
                
            }
            if(tempTocheck >100)
            {
                returnArray[j++]=0;                
            }
        }
        
        
     return returnArray;   
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DailyTemperatures739 d= new DailyTemperatures739();
		int returnArray[]=d.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
		
System.out.println(Arrays.toString(returnArray));
	}

}
