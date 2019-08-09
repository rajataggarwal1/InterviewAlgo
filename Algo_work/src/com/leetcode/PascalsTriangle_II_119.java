package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 119. Pascal's Triangle II
Easy

441

156

Favorite

Share
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 * 
 * 
 * 
 * @author rajat
 *
 */
public class PascalsTriangle_II_119 {
	
	// This is iterative solution and need to work on recursion solution
	 public List<Integer> getRow(int rowIndex) {
	        List<Integer> tempList=new ArrayList<Integer>();
	        
	        // Seeting rowindex to 1 so that we can start index from 1. As per input 0 is first row
	        rowIndex=rowIndex+1;
	        if(rowIndex ==1)
	        {
	            tempList.add((Integer) 1);  
	            return tempList;
	        }
	        if(rowIndex >=1)
	        {            
	            tempList.add((Integer) 1);           
	        }
	        
	        List<Integer> returnList=new ArrayList<Integer>();
	        for(int i=2; i<=rowIndex; i++ )
	        {
	            
	             returnList.clear();
	            for(int j=1; j<=i; j++ )
	            {
	                if(i==j || j==1)
	                {
	                   
	                    returnList.add((Integer) 1);
	                }
	                else
	                {
	                    // getting value from previous list to calculate next list column value. we are going to use same list again to save the space. 
	                    //We will clear the list once its use finished. We only care about last list.
	                    Integer calculateNextValue=tempList.get(j-2) + tempList.get(j-1);
	                    returnList.add(calculateNextValue);
	                }
	            }
	            tempList.clear();
	            tempList.addAll(returnList);
	           
	             
	        }
	            
	        return returnList;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangle_II_119 p = new PascalsTriangle_II_119();
		List<Integer> list=p.getRow(5);
		
		System.out.println(list);
	}

}
