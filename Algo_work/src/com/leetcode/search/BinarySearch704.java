package com.leetcode.search;
/*
 * https://leetcode.com/problems/binary-search/
 * 704. Binary Search
Easy

196

27

Favorite

Share
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].
 * 
 * 
 */
public class BinarySearch704 {
	 public static int search(int[] nums, int target) {
	        
	        int pivet=nums.length/2;
	        
	        int i=0;
	        int j=nums.length;
	        while(i<=j && pivet< nums.length)
	        {
	          //  System.out.println("pivet "+pivet);
	            if(nums[pivet]== target)
	            {
	                return pivet;
	            }
	            else if(nums[pivet]< target)
	            {
	                i=pivet+1;
	                pivet= (i+j)/2;
	            }
	            else
	            {
	                j=pivet-1;
	                pivet= (i+j)/2;
	            }
	            
	        }
	        return -1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6,7};
		int index=search(arr,3);
		System.out.println(index);
		
		
		int arr1[]= {-1,0,3,5,9,12};
		 index=search(arr1,9);
		System.out.println(index);
		
		int arr2[]= {-1,0,3,5,9,12};
		index=search(arr2,2);
		System.out.println(index);
	}

}
