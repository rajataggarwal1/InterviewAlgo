package com.leetcode.Meetup.SolvedByOthers;
/**
 *https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 *
 * 
 * 1155. Number of Dice Rolls With Target Sum
Medium

72

8

Favorite

Share
You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.

 

Example 1:

Input: d = 1, f = 6, target = 3
Output: 1
Explanation: 
You throw one die with 6 faces.  There is only one way to get a sum of 3.
Example 2:

Input: d = 2, f = 6, target = 7
Output: 6
Explanation: 
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
Example 3:

Input: d = 2, f = 5, target = 10
Output: 1
Explanation: 
You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
Example 4:

Input: d = 1, f = 2, target = 3
Output: 0
Explanation: 
You throw one die with 2 faces.  There is no way to get a sum of 3.
Example 5:

Input: d = 30, f = 30, target = 500
Output: 222616187
Explanation: 
The answer must be returned modulo 10^9 + 7.
 

Constraints:

1 <= d, f <= 30
1 <= target <= 1000
 * 
 * 
 * 
 * @author rajat
 *
 */
public class NumberofDiceRollsWithTargetSum1155 {

	public int numRollsToTarget(int d, int f, int target) {
        Integer[][] memo = new Integer[d + 1][target + 1];
        return helper(d, f, target, memo);
    }
    
    public int helper(int d, int f, int target, Integer[][] memo) {
        if (d == 0 || target <= 0) {
            return d == target ? 1 : 0;
        }
        if (memo[d][target] != null) {
            return memo[d][target];
        }
        memo[d][target] = 0;
        for (int i = 1; i <= f; i++) {
            memo[d][target] = (memo[d][target] + helper(d - 1, f, target - i, memo)) % 1000000007;
        }
        return memo[d][target];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofDiceRollsWithTargetSum1155 m=new NumberofDiceRollsWithTargetSum1155();
		System.out.println(m.numRollsToTarget(30,30,500));
		
		System.out.println(m.numRollsToTarget(5,20,50));
		
		
	}

}
