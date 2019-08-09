package com.leetcode.Meetup.SolvedByOthers;
/*
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * Can check on leetfree.com
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 

Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
 * 
 * 
 */
public class PartitiontoKEqualSumSubsets698 {

	/*c++ code needs to convert in java
	 * 
	 * def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        subsets = []
        for i in range( k ):
            subsets.append( 0 )
        total = 0
        for num in nums:
            total += num
        target = total / k
        # Two quick checks: forming subsets each with a sum of k is impossible if k isn't an integer or if any of the integers in nums is greater than k
        if target != int( target ):
            return False
        nums.sort( reverse=True )
        for num in nums:
            if num > target:
                return False        
       
        def partitionHelper( nums, subsets ):
            if not nums:
                sums = [ target == subset for subset in subsets ]
                return all( sums )
            else:
                num = nums[ 0 ]
                for i in range( k ):
                    newSubsets = subsets
                    if newSubsets[ i ] + num <= target:
                        newSubsets[ i ] += num
                        if partitionHelper( nums[ 1: ], newSubsets ):
                            return True
                        newSubsets[ i ] -= num
                    else:
                        continue
                return False
        return partitionHelper( nums, subsets )
	 * 
	 * 
	 */
	// Java solution
	public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i< nums.length; i++){
            sum +=nums[i];
        }
        if(sum%k !=0 )
            return false;
        int eachSum = sum/k;
        boolean visited[] = new boolean[nums.length];
        return createSum(nums, 0, visited,eachSum, eachSum, k);    
    }
   
    boolean createSum(int[]nums ,int start, boolean[] visited, int startSum, int eachSum, int k){
        if(k==0){
            return true;
        }
        if(eachSum == 0){
            // decrease k
            return createSum(nums, 0, visited, startSum, startSum, k-1);
           
        }
        for(int i=start; i< nums.length; i++){
            if(visited[i] || nums[i]>eachSum){
                continue;
            }
           
            if(eachSum - nums[i] >=0){
                //decrease the counter and send this map to createSum
                visited[i] = true;
                boolean isPossible = createSum(nums, start+1, visited, startSum, eachSum-nums[i], k);
               //backtrack add the element back in the map
               if(!isPossible){
                   visited[i] = false;
                }  
                else
                  return isPossible;
            }
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]= {4, 3, 2, 3, 5, 2, 1};

PartitiontoKEqualSumSubsets698 p= new PartitiontoKEqualSumSubsets698();

System.out.println(p.canPartitionKSubsets(arr,4));


	}

}
