package com.leetcode;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * 977. Squares of a Sorted Array
Easy

472

50

Favorite

Share
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
 * 
 * 
 * 
 */
public class SquaresofaSortedArray977 {

	public int[] sortedSquares(int[] A) {
	     
	      // using two pointer approach and build the result array
	      // first calculate the squar and then go thru the array from comparing low with high and start moving into result array which ever is greater.
	      // iterate result array from right to left
	        if(A.length==0)
	            return A;
	        
	        int low=0;
	        int high=A.length-1;
	      // calculating squar  
	      for(int i=0; i< A.length; i++)
	      {
	           A[i]=A[i]*A[i];  
	      }
	     // System.out.println(Arrays.toString(A));
	  
	      int resultArr[]=new int[A.length];
	        int len=resultArr.length-1;
	      
	      // building result array from comparing low with high
	        while(low<=high)
	        {
	            if(Math.abs(A[low]) <= Math.abs(A[high]))
	            {
	                     resultArr[len--]= A[high--]; 
	            }
	            else
	            {
	                    resultArr[len--]= A[low++];   
	            }
	 //System.out.println("*"+ Arrays.toString(resultArr));
	        }
	        
	        
	       return resultArr; 
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquaresofaSortedArray977 s=new SquaresofaSortedArray977();
		
		int arr[]= {-4,-1,0,3,10};
		
		System.out.println(Arrays.toString(s.sortedSquares(arr)));
		
		int arr1[]= {-7,-3,2,3,11};
		System.out.println(Arrays.toString(s.sortedSquares(arr1)));
		
		int arr2[]= {-3,-3,-2,1};
		System.out.println(Arrays.toString(s.sortedSquares(arr2)));
		
	}

}
