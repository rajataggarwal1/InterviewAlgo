package com.leetcode.Meetup.SolvedByOthers;
/*https://leetcode.com/problems/combination-sum/
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 * 
 * 
 * 
 */
public class CombinationSum36 {

	/**
	 * Code is python. Need to implement in java
	 * 
	 * def combinationSum(self, a, t):
        def csum(i, tres, tsum):
            if tsum == t:
                res.append(copy(tres))
                return
            if tsum > t or i == len(a):
                return
            tres.append(a[i])
            tsum += a[i]
            csum(i, tres, tsum)
            del tres[-1]
            tsum -= a[i]
            csum(i+1, tres, tsum)
        res = []
        csum(0, [], 0)
        return res
        
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
