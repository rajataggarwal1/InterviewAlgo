package com.leetcode;
/*
 * https://leetcode.com/problems/house-robber/
 * 198. House Robber
Easy

3251

111

Favorite

Share
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * 
 * 
 */

/*
 * DP array for input [1,2,3,1]
 * 
 * [0,1, 2,4,4]
 * 
 * Dp array for input [2,1,1,2]
 * 
 * [0,2,2,3,4]
 * 
 */


public class HouseRobber198 {

	public int rob(int[] nums) {
        // Problem can be solved using DP.
        // Create DP array of arraysize+1
        // initialize first element with 0 because no house and first element with arr[0]
        // apply formula dp[i]=(Math.max(arr[curr]+ dp[i-2], dp[i-1])
        //            updating curr dp with check curr and alternate wich is -2 and with current-1
        // whicheveris greate will be the current elemt value.
        // This O(n) and O(n) space.
        // Another approach is that we can use two variable for last two value as we care only last values
        
        if(nums.length == 1)
            return nums[0];
        
        if(nums.length ==0)
            return 0;
        
        int dp[]= new int[nums.length+1];
        dp[0]=0;   // because there no house so nothing to rob
        dp[1]=nums[0]; // assigning first element value from given house array
        int arraypointer=1;
        
        // running loop to fill dp array
        
        for(int i=2; i< dp.length; i++)
        {
            // taking cuurent array val and finding max with alternate
            dp[i]=Math.max(nums[arraypointer++] + dp[i-2], dp[i-1]);
            
        }
        
        
        return dp[dp.length-1];
        
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber198 r=new HouseRobber198();
		
		int[]nums= {1,2,3,1};
		
		System.out.println(r.rob(nums));
		
	}

}
