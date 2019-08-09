package com.leetcode;
/*
 * https://leetcode.com/problems/sliding-window-maximum/
 * 239. Sliding Window Maximum
Hard

1494

88

Favorite

Share
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 * 
 * 
 * 
 */
public class SlidingWindowMaximum239 {

	public int[] maxSlidingWindow(int[] nums, int k) {
      
        
        if(k==1)
            return nums;
        if(nums.length==0)
            return nums;
      
        int returnArr[]=new int[nums.length-k+1];
        
        int l=0;
        
        for(int i=0; i< nums.length; i++)
        {
            int max=nums[i];
            //innerloop to check sliding window
            for(int j=i; j<i+k && j < nums.length; j++)
            {
                if(nums[j]> max)
                    max=nums[j];
                
            }
            if(l<returnArr.length)
            {
                returnArr[l++]=max;
            }
            else
                break;
        }
        
        return returnArr;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        	SlidingWindowMaximum239 sld=new SlidingWindowMaximum239();
        	int arr[]= {1,3,-1,-3,5,3,6,7};
        	int resultArr[]=sld.maxSlidingWindow(arr, 3);
        	
        	for(int i=0; i< resultArr.length; i++)
        	{
        		System.out.print(resultArr[i] + ",");
        	}
	}

}
