package com.leetcode;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 * 1005. Maximize Sum Of Array After K Negations
Easy

59

10

Favorite

Share
Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.

 

Example 1:

Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].
Example 2:

Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
Example 3:

Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 

Note:

1 <= A.length <= 10000
1 <= K <= 10000
-100 <= A[i] <= 100
Accepted
 * 
 * 
 */
public class MaximizeSumOfArrayAfterKNegations1005 {

	public int largestSumAfterKNegations(int[] A, int k) {
        // First sort array to get all negative at first
        Arrays.sort(A);
        //Loop to iterate all negative and convert then to positive int and decrease the count of k
        for(int i=0; i< A.length && k>0; i++)
        {
            if(A[i]<0)
            {
                A[i]=-1*A[i];
                k--;
                
            }
            if(i<A.length-1 && A[i+1]>=0 )
            {
            	break;
            }
            
        }
        // once all negative converted then sort again to get lowest positive at first locayion
        Arrays.sort(A); 
        
         // Do mode so that we new if we have to perform any operation or not. If mode then simply so -1 
        if(k> 0 && k%2!=0)
        {
        	A[0]=-1*A[0];
        }
       
        int sum=0;
        
        for(int i=0; i< A.length; i++)
        {
            sum=sum+A[i];
        }
        
        
       return sum; 
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximizeSumOfArrayAfterKNegations1005 m=new MaximizeSumOfArrayAfterKNegations1005();
		int A[]= {-8,3,-5,-3,-5,-2};
		System.out.println(m.largestSumAfterKNegations(A, 6));
		
		int A1[]= {4,2,3};
		System.out.println(m.largestSumAfterKNegations(A1, 1));
		int A2[]= {3,-1,0,2};
		System.out.println(m.largestSumAfterKNegations(A2, 3));
		int A3[]= {2,-3,-1,5,-4};
		System.out.println(m.largestSumAfterKNegations(A3, 2));
		int A4[]= {1,3,2,6,7,9};
		System.out.println(m.largestSumAfterKNegations(A3, 3));
		
		int A5[]= {-8,-3,-5,-3,-5,-2};
		System.out.println(m.largestSumAfterKNegations(A5, 6));
	}

}
