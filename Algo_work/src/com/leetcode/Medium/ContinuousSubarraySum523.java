package com.leetcode.Medium;
/*
 * 523. Continuous Subarray Sum
 * https://leetcode.com/problems/continuous-subarray-sum/
Medium

Share
Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.

 Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 

Note:

The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 * 
 */

public class ContinuousSubarraySum523 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContinuousSubarraySum523 c=new ContinuousSubarraySum523();
		int nums[]= {23, 2, 6, 4, 7};
		System.out.println(c.checkSubarraySum(nums, 6));
		System.out.println(c.checkSubarraySum(nums, -6));
		
		int nums1[]= {23, 2, 4, 6, 7};
		System.out.println(c.checkSubarraySum(nums1, 6));
		System.out.println(c.checkSubarraySum(nums1, 0));
		
		int nums2[]= {0,0,0};
		System.out.println(c.checkSubarraySum(nums2, 0));
		
	}
	public boolean checkSubarraySum(int[] nums, int k) {
	       
	      /* Mutiple edge case. 
	        1. divided by zero
	        2. if k is negavive then make absolute value of it
	        3. if length is 1 then return false
	        and also it will be continous
	        Two loop to calculate continous sum, Return true as soon as found two value with multiple of K
	                
	        */
	        
	       k=Math.abs(k);
	        if(nums.length==1)
	            return false;
	        
	        for(int i=0; i< nums.length-1; i++)
	        {
	            int sum=nums[i];      
	              
	            
	            for(int j=i+1; j< nums.length; j++)
	            {
	                sum+=nums[j];
	                
	                if(k > 0)
	                {
	                    if((sum%k) == 0)
	                    {
	                        return true;
	                    }
	                }
	            }
	            
	            if(sum == 0 && k==0)
	            {
	                return true;
	            }
	        }
	        
	        return false;
	        
	    }

}
