package com.leetcode.Medium;
/*
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
Medium

2557

115

Favorite

Share
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
public class MaximumProductSubarray152 {

	public int maxProduct(int[] nums) {
        
        // initilize maxproduct and productsofar with integer min value
        // Main trick here is we have to check each element for max product and as well each susequent element 
        // so we have to add two check one while entering in the innerloop and other inside inner loop
        // check if maxproduct is less then max product then store and finally return the result
        int maxProductSofar=Integer.MIN_VALUE;
        int maxProduct=Integer.MIN_VALUE;
        
        for(int i=0; i< nums.length; i++)
        {
            maxProductSofar=nums[i];
             if(maxProductSofar > maxProduct)
            {
                maxProduct= maxProductSofar;
            }
            
            for(int j=i+1; j< nums.length; j++)
            {
                
                maxProductSofar=maxProductSofar*nums[j];
                if(maxProductSofar > maxProduct)
                {
                    maxProduct= maxProductSofar;

                }
               
            }
            
                
        }
        
        return maxProduct;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductSubarray152 s=new MaximumProductSubarray152();
		int arr1[]= {-2,3,-2,14};
		int arr2[] = {2,3,-2,4};
		
		System.out.println(s.maxProduct(arr1));
		System.out.println(s.maxProduct(arr2));
		
	}

}
