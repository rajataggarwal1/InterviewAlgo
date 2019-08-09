package com.leetcode;

import java.util.Arrays;

/*
 * 
 * 53. Maximum Subarray
Easy

3815

132

Favorite

Share
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 * 
 */
public class MaximumSubarray53 {
public static int maxSubArray(int[] nums) {
        
        int tempSum[]= new int[nums.length+1];
        
        Arrays.fill(tempSum,0);
        
        int sum=0;
        
        // Edge condition
        if(nums.length <1)
            return 0;
        else if (nums.length==1)
        {
            return nums[0];
        }
        
        //first checking whether array is all negative or not. My program was failing on all negative value
       int returnSum=Integer.MIN_VALUE;
        boolean allNegative=false;
        
        for(int i=0; i< nums.length; i++)
        {
          // Break from loop if any positive found
            if(nums[i] >= 0)
            {
                allNegative=false;
                break;
            }
            
            if(nums[i] < 0 && returnSum<nums[i])
            {
                
                returnSum=nums[i];
                allNegative=true;
            }
           
        }
        
        if(allNegative)
            return returnSum;
        else
        {
            // checking for all other value including negative and positive
            //builing tempsum array using dynamic programing which take extra space
            //exampel
            //Input                 [-2,1,-3,4,-1,2,1,-5,4]
            // new array will be   [0,0,1,0,4,3,5,6,1,5]   for each negative sume putting zero else calulating maximum sum
            for(int i=0, j=1; i<nums.length; i++,j++)
            {
               //  System.out.println("t " +tempSum[j-1]);
                sum= nums[i]+tempSum[j-1];
               // System.out.println(sum);
                if(sum < 0)
                {
                    tempSum[j]=0;
                    sum=0;
                }
                else
                {
                    tempSum[j]=sum;
                }

            }
        }
        
        
         returnSum=tempSum[0];
        for(int j=1; j< tempSum.length; j++)
        {
            if(returnSum<tempSum[j])
            {
                returnSum=tempSum[j];
            }
        }
        
        return returnSum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=  {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(arr));
		int arr2[]=  {-2,-3};
		System.out.println(maxSubArray(arr2));
		int arr3[]=  {-2,0};
		System.out.println(maxSubArray(arr3));
	}

}
