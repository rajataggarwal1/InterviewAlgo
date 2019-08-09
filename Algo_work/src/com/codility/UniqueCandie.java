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


public class UniqueCandie {

	/**
	 * @param args
	 */
	 public int solution(int[] T) {
	        // write your code in Java SE 8
	        
		 
		 
		 int arrSize= T.length;
			
		 Map map= new HashMap();
		  
		 if(T.length > 0)
		 {
			 int noOfUnique=arrSize/2;
			 //Sorting the array
			 
			 
			 //converting array into map and removing duplicate
			 for (int i=0;i <T.length;i++)
			 {
				 
				 if(map.containsKey(T[i]) != true)
				 {
					 map.put(T[i], T[i]);
				 }
				 
			 }
			 
			 if ( map.size() <=  noOfUnique )
			 {
				 return map.size();
			 }
			 else
			 {
				 return noOfUnique;
			 }
			 
		      
		 }
		 else
			 return  0;
		 
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int arr1[]= {1, 3, 6, 4, 1, 2};
		int arr1[]= {3, 4, 7, 7, 6, 6};
		//int arr1[]= {80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789};
		//int arr1[]= {1,1,1,1};
		//int arr1[]= {};
		
		UniqueCandie sp=new UniqueCandie();
		
		int result=sp.solution(arr1);
		
		System.out.println(result);
	}

}
