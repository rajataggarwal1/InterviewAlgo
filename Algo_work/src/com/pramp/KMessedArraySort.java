package com.pramp;
/*
 * https://www.pramp.com/challenge/XdMZJgZoAnFXqwjJwnBZ
 * K-Messed Array Sort
Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.

Analyze the time and space complexities of your solution.

Example:

input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ 100
[input] integer k

1 ≤ k ≤ 20
[output] array.integer
 * 
 * 
 */
public class KMessedArraySort {
	static int[] sortKMessedArray(int[] arr, int k) {
	    // your code goes here
	    
	    int arrSize=arr.length;
	    
	    for(int i=0; i<arrSize; i++)
	    {
	     // int val=arr[i];
	      for(int j=i+k ; j < arrSize && j> i; j--)
	      {
	        //k=2
	      /*  1 4 7 
	      
	     
	        
	        // [6,1,4,11,2,0,3,7,10,5,8,9], 6
	        6 1 4 11 2 0 3
	        6 1 4 11 0 2 3
	        0 6 1  4 11  2 3 7
	        0 6 1 4 2 11 3 7
	        0 1 2 6 4 3  11 7 10
	            2 6 4 3 7 11 10
	            2 6 4 3 7 10 11
	            2 3 4 6 7 10 11 5
	        
	        
	        
	        // i = 0; j = 6
	          
	         */ 
	          
	        if(arr[j] < arr[j-1])
	        {
	          int temp=arr[j-1];
	          arr[j-1]=arr[j];
	          arr[j]= temp;
	          
	        }
	        
	        
	      }
	      
	      
	    }
	    
	    return arr;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int []inputArr= {1, 4, 5, 2, 3, 7, 8, 6, 10, 9}; //k=2
		int []inputArr= {6,1,4,11,2,0,3,7,10,5,8,9}; // k= 6 // Not working
		
	    int [] resultArr=sortKMessedArray(inputArr,9);
	    
	    for(int i=0; i<resultArr.length; i++)
	    {
	      System.out.print(resultArr[i]+ " ");
	    }

	}

}
