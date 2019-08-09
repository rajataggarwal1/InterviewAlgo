package com.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
 * Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [-1,-3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [-1,000,000..1,000,000].
 * 
 * 
 * */


public class SmallestPositive {

	/**
	 * @param args
	 */
	 public int solution(int[] A) {
	        // write your code in Java SE 8
	        
		 
		 int result=0;
		 int countval=1;
		 int arrSize= A.length;
		 Map map= new HashMap();
		 
		
		 
		 if(A.length > 0)
		 {
			 //Sorting the array
			 Arrays.sort(A);
			 if( A[arrSize-1] <= 0)
			 {
				 return 1;
			 }
			 
			 //converting array into map and removing duplicate
			 for (int i=0;i <A.length;i++)
			 {
				 
				 if(map.containsKey(A[i]) != true)
				 {
					 map.put(A[i], A[i]);
				 }
				 
			 }
			 //
			 //Iterating array again  for checking missing element
			 for(int i=1; i<= map.size(); i++)
			 {
				 if(map.containsKey(i) != true)
				 {
					 result=i;
					 break;
				 }
					countval++;
			 }
			 
			 if(result==0)
			 {
				 result = countval; 
			 }
			 
		       return  result;
		 }
		 else
			 return  1;
		 
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]= {1, 3, 6, 4, 1, 2};
		//int arr1[]= {6,5,3,4,1,7};
		//int arr1[]= {1,2,3};
		//int arr1[]= {-1,-2};
		//int arr1[]= {};
		
		SmallestPositive sp=new SmallestPositive();
		
		int result=sp.solution(arr1);
		
		System.out.println(result);
	}

}
