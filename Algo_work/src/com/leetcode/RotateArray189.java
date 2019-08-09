package com.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/rotate-array/
 * 189. Rotate Array
Easy

1165

578

Favorite

Share
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 * 
 * 
 * 
 * 
 */
public class RotateArray189 {
	 public void rotate(int[] nums, int k) {
	       // Solving this problem in two parts. 
	        //First check if array is greater than k
	        // if yes, Create temp Array with size k and copy last k element into new tempary array.
	        // then rum the loop from length to zero and in one pass copy all the value from array length -k to length
	        
	        if(nums.length>k)
	        {
	            int []tempArr=new int[k];
	            tempArr=Arrays.copyOfRange(nums, nums.length-k, nums.length);
	            for(int i=nums.length-1;i>=0;i--)
	            {
	                if(i>=k)
	                {
	                    nums[i]=nums[i-k]; // copying value from if i=7 and k=3 then index=3 to index-6
	                }   
	                else if(i<k)
	                {
	                // System.out.println(nums[i] + " "+i);
	                    nums[i]=tempArr[i]; // now fill the temp arr value
	                }
	            }
	            
	        }
	        else if(nums.length<k && nums.length>0) // second condition is if array is less then k and array has atleast one element 
	        {
	            // run the loop from k-array length because we need to rotate only that many element.
	            // array size is 2 and k is 3 then in first two pass the array value will be same so need to run only one pass
	            for(int i=0; i< k-nums.length; i++)
	            {
	               int temp=nums[nums.length-1];
	                // Copy all element of array from lendth-1 position to length position and we left with first space.
	                // later replace array's first element with the element saved in tem which was picked from last arraly location.
	                // This brut force way.
	                for(int j=nums.length-1; j>0; j--)
	                {
	                    nums[j]=nums[j-1];
	                }
	                
	                nums[0]= temp;
	               
	            }
	        }
	        
	        // if array length and k is equal then we donot have to do anything keep array unchanged.

            for(int i=0;i<nums.length;i++)
            	System.out.print(nums[i]+ ",");
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateArray189 r=new RotateArray189();
		int arr[]= {1,2,3,4,5,6,7};
		r.rotate(arr,3);
		
		System.out.println();
		int arr1[]= {-1,-100,3,99};
		r.rotate(arr1,2);
		
		System.out.println();
		int arr2[]= {1,2};
		r.rotate(arr2,3);
		
	}

}
