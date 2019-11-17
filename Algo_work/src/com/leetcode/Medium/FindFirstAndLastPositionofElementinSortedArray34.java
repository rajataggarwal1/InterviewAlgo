package com.leetcode.Medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 34. Find First and Last Position of Element in Sorted Array
Medium

2202

103

Favorite

Share
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 * 
 * 
 * 
 * 
 */
public class FindFirstAndLastPositionofElementinSortedArray34 {
	
	 public int[] searchRange(int[] nums, int target) {
	      // Solving using binary search. 
	        //Once got the target then start using sliding window 
	        // start expending from mid to find all target from left and right
	        // i is left and j is right and add these value in result by i+1 and j-1 
	        // because it will go beyond the index to break the condition.
	        
		 // We can also use to binary serach, one for left and one for right. 
		 // check >= and <= for getting mid
		 
	        int start=0;
	        int end=nums.length-1;
	        
	        int pos=-1;
	        int result[]=new int[2];
	        int mid=start+(end-start)/2;
	        
	        while(start <= end)
	        {
	            mid=start+(end-start)/2;
	            if(nums[mid]==target)
	            {
	                pos=mid;
	                break;
	            }
	            else if(nums[mid]<target)
	            {
	                start=mid+1;
	            }
	            else
	            {
	                end=mid-1;
	            }
	            
	        }
	        
	      //  System.out.println("mid "+mid);
	        if(pos==-1)
	        {
	            result[0]=-1;
	            result[1]=-1;
	        }
	        else
	        {
	            int i=mid;
	            int j=mid;
	            while((i>=0 && nums[i] == target) || (j< nums.length && nums[j] == target))
	            {
	               // System.out.println("nums[i] "+nums[i]+ " nums[j] "+nums[j]);
	                if(i>=0 && nums[i]==target)
	                {
	                    i--;
	                }
	                if(j< nums.length && nums[j]==target)
	                {
	                    j++;
	                }
	                
	            }
	            
	            result[0]=i+1;
	            result[1]=j-1;
	        }
	        
	        
	        return result;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFirstAndLastPositionofElementinSortedArray34 f=new FindFirstAndLastPositionofElementinSortedArray34();
		
		int nums[]= {5,7,7,8,8,10};
		
		System.out.println(Arrays.toString(f.searchRange(nums, 8)));
	}

}
