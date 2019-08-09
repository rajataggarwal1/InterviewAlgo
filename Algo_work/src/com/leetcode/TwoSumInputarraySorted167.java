package com.leetcode;

import java.util.Arrays;

/*
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 */
public class TwoSumInputarraySorted167 {
	public int[] twoSum(int[] numbers, int target) {
        
        int returnarr[]=new int[2];
        int num=0;
        
        for (int i=0; i<numbers.length;i++)
        {
             num=target-numbers[i];
            
            for(int j=i+1; j<numbers.length;j++ )
            {
                if(num==numbers[j])
                {
                    returnarr[0]=i+1;
                    returnarr[1]=j+1;
                    break;
                }
            }
                
            
            
        }
        
        Arrays.sort(returnarr);
        return returnarr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSumInputarraySorted167 tw=new TwoSumInputarraySorted167();
		int arr[]= {2,7,11,15};
		int result[]=tw.twoSum(arr,9);
		
		for(int i=0;i<result.length;i++)
		{
			System.out.println(result[i]);
		}
	}

}
