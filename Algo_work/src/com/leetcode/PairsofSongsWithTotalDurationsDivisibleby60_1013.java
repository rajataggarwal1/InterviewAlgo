package com.leetcode;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * 1013. Pairs of Songs With Total Durations Divisible by 60
Easy

70

4

Favorite

Share
In a list of songs, the i-th song has a duration of time[i] seconds. 

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 

Note:

1 <= time.length <= 60000
1 <= time[i] <= 500
 * 
 * 
 */
public class PairsofSongsWithTotalDurationsDivisibleby60_1013 {
	
	// This works but not able to submit becuase of timeoutException
	// Timecomplexity is O(n2) and slow.
	 public int numPairsDivisibleBy60_Inefficient(int[] time) {
	        
	        int count=0;
	            
	        for(int i=0; i<time.length; i++)
	        {
	            int j=time.length-1;
	            
	            while(i<j)
	            {
	                int sum= time[i]+time[j];
	                
	                if(sum%60==0)
	                    count++;
	                
	                j--;  
	            }
	        }
	      
	        return count;
	        
	    }
	 // Solution by other engineer in leet code meetup
	 public int numPairsDivisibleBy60(int[] time) {
	        int count =0;
	        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
	      for(int x: time){
	          int t = x%60;
	          int tcomp = (60-t)%60 ;
	              if(map.get(tcomp)!=null)
	          {count+=map.get(tcomp);  }
	         map.put(t, map.getOrDefault(t,0)+1 );
	          
	          
	      }
	        return count;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairsofSongsWithTotalDurationsDivisibleby60_1013 p=new PairsofSongsWithTotalDurationsDivisibleby60_1013();
		
		int time[]= {30,20,150,100,40};
		System.out.println(p.numPairsDivisibleBy60_Inefficient(time));
		
		
		
		System.out.println(p.numPairsDivisibleBy60(time));
	}

}
