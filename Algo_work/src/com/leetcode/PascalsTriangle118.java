package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 118. Pascal's Triangle
Easy

653

74

Favorite

Share
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * 
 * 
 * 
 */
public class PascalsTriangle118 {
	// Iterative solution. I need to work on recursive solution
public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> returnList=new ArrayList<List<Integer>>();
        
        if(numRows >=1)
        {
             List<Integer> tempList=new ArrayList<Integer>();
            tempList.add((Integer) 1);
            returnList.add(tempList);
        }
        
        for(int i=2; i<=numRows; i++ )
        {
            List<Integer> tempList=new ArrayList<Integer>();
            for(int j=1; j<=i; j++ )
            {
                if(i==j || j==1)
                {
                   
                    tempList.add((Integer) 1);
                }
                else
                {
                    // getting value from previous list to calculate next list column value. We are going previous row nad previous two column
                    Integer calculateNextValue=returnList.get(i-1-1).get(j-1-1) + returnList.get(i-1-1).get(j-1);
                    tempList.add(calculateNextValue);
                }
            }
           
             returnList.add(tempList);
             
        }
            
        return returnList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangle118 p=new PascalsTriangle118();
		
		List<List<Integer>> list=p.generate(5);
		
		System.out.println(list);
	}

}
