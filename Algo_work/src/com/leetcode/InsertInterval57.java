package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author rajat
 *Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]
 */


// Definition for an interval.
  class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}


public class InsertInterval57 {

	 public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        
		 List<Interval> resultList= new ArrayList<Interval>(); 
	        int intervalsSize= intervals.size()+1;
	        int startArr[]= new int[intervalsSize];
	        int endArr[]= new int[intervalsSize];
	        
	        int i=0;
	        int j=0;
	        
	        // breaking start and end into seperate array
	        for(Interval inter: intervals){
	        	startArr[i++]=inter.start;
	        	endArr[j++]=inter.end;
	        }
	        // Adding new interval into start and end array
	        startArr[i]=newInterval.start;
        	endArr[j]=newInterval.end;
        	
	        // sorting array after inserting new interval
        	Arrays.sort(startArr);
        	Arrays.sort(endArr);
        	
        	
        	i=0;j=0;
        	while(intervalsSize > j)
        	{
        		//j==intervalsSize-1 condition for last element otherwise it will be arrayindexoutof bound exception. Because if check first condition first
        		//if it is tru then skip next condition.
        		if(j==intervalsSize-1 ||endArr[j] < startArr[j+1])
        		{
        			Interval inter= new Interval(startArr[i], endArr[j]);
        			resultList.add(inter);
        			// Moving i poiner to next element which require to add 
        			i=j+1;
        		}
        		j++;
        		
        	}
        	
        	
        	return resultList;
        	
	    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertInterval57 inter=new InsertInterval57();
		
		 List<Interval> resultList= new ArrayList<Interval>(); 
		 resultList.add(new Interval(1,3));
		 resultList.add(new Interval(6,9));
		 
		List<Interval> result=inter.insert(resultList, new Interval(2,5));
		
		for(Interval intera:result){
        	System.out.print(intera.start+"," + intera.end + "  ");
        	
        }
		
		 List<Interval> resultList1= new ArrayList<Interval>(); 
		 resultList1.add(new Interval(1,2));
		 resultList1.add(new Interval(3,5));
		 resultList1.add(new Interval(6,7));
		 resultList1.add(new Interval(8,10));
		 resultList1.add(new Interval(12,16));
		 
		List<Interval> result1=inter.insert(resultList1, new Interval(4,8));
		System.out.println();
		for(Interval intera:result1){
        	System.out.print(intera.start+"," + intera.end + "  ");
        	
        }
		
	}

}
