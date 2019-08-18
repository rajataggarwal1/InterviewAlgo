package com.DailyCoadingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This problem was asked by Google.

Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
 * 
 * */

public class SubsetSum {

	/**
	 * @param args
	 */
	// Solution using dynamic programming taken from geekgforgeek
	// Returns true if there is a subset of  
    // set[] with sun equal to given sum 
    static boolean isSubsetSum(int set[],  
                             int n, int sum) 
    { 
        // The value of subset[i][j] will be 
        // true if there is a subset of  
        // set[0..j-1] with sum equal to i 
        boolean subset[][] =  
                     new boolean[sum+1][n+1]; 
      
        // If sum is 0, then answer is true 
        for (int i = 0; i <= n; i++) 
            subset[0][i] = true; 
      
        // If sum is not 0 and set is empty, 
        // then answer is false 
        for (int i = 1; i <= sum; i++) 
            subset[i][0] = false; 
      
        // Fill the subset table in botton 
        // up manner 
        for (int i = 1; i <= sum; i++) 
        { 
            for (int j = 1; j <= n; j++) 
            { 
                subset[i][j] = subset[i][j-1]; 
                if (i >= set[j-1]) 
                subset[i][j] = subset[i][j] ||  
                     subset[i - set[j-1]][j-1]; 
            } 
        } 
      
        // uncomment this code to print table 
        for (int i = 0; i <= sum; i++) 
        { 
        for (int j = 0; j <= n; j++) 
            System.out.print(" "+subset[i][j]); 
        System.out.println();
        } 
      
        return subset[sum][n]; 
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


      //  int set[] = {3, 34, 4, 12, 5, 2}; 
		  int set[] = {3, 34, 5, 2};
        //int sum = 9; 
        int sum = 7;
        int n = set.length; 
        if (isSubsetSum(set, n, sum) == true) 
            System.out.println("Found a subset"
                          + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum"); 
    } 
		
	

}
