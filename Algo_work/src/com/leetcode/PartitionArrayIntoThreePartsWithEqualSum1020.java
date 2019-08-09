package com.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 * 1020. Partition Array Into Three Parts With Equal Sum
Easy

49

9

Favorite

Share
Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])

 

Example 1:

Input: [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
Example 2:

Input: [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false
Example 3:

Input: [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 

Note:

3 <= A.length <= 50000
-10000 <= A[i] <= 10000
 * 
 */
public class PartitionArrayIntoThreePartsWithEqualSum1020 {
	 public boolean canThreePartsEqualSum(int[] A) {
	        int sum=Arrays.stream(A).sum();
	     
	        // first check whether sum is divisible by 3 or not because we are looking 3 subarray whose sum is equal to each other
	        if(sum%3!=0)
	            return false;
	        
	        // getting sum for each subarray
	        int eachArraySum=sum/3;
	        
	        int temeachSubArraySum=eachArraySum;
	        
	        // loop and check if sum is zero after complete iteration and each sub sum is also zero
	        for(int i=0; i< A.length; i++)
	        {
	            temeachSubArraySum=temeachSubArraySum-A[i];
	            
	            if(temeachSubArraySum==0)
	            {              
	                temeachSubArraySum=eachArraySum;
	                sum=sum-eachArraySum;
	            }
	            
	            
	        }
	        
	 // Check if sum is zero means all subarray has equal sum        
	        if(sum==0 )
	            return true;
	     
	        // else return false
	        return false;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionArrayIntoThreePartsWithEqualSum1020 p=new PartitionArrayIntoThreePartsWithEqualSum1020();
		int A[]= {0,2,1,-6,6,-7,9,1,2,0,1};
		System.out.println(p.canThreePartsEqualSum(A));
		
		int A1[]= {0,2,1,-6,6,7,9,-1,2,0,1};
		System.out.println(p.canThreePartsEqualSum(A1));
		
		int A2[]= {3,3,6,5,-2,2,5,1,-9,4};
		System.out.println(p.canThreePartsEqualSum(A2));
		
		
	}

}
