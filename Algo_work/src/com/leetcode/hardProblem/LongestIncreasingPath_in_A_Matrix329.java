package com.leetcode.hardProblem;
/*
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * 329. Longest Increasing Path in a Matrix
Hard

1145

21

Favorite

Share
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 * 
 * 
 * 
 * 
 */
public class LongestIncreasingPath_in_A_Matrix329 {

	public int longestIncreasingPath(int[][] matrix) {
        
	     //   Map<String, Integer> map=new HashMap<>();
	        
	        if(matrix.length == 0)
	            return 0;
	        
	        int maxCountSoFar=0;
	        int longestCount=0;
	        
	        int row=matrix.length;
	        int col=matrix[0].length;
	        
	        
	        for(int i=0; i<row; i++)
	        {
	            
	            
	            for(int j=0; j<col; j++)
	            {
	                
	              longestIncreasingPathHelper(matrix, i, j,1);                
	                
	                if(longestCount < longCount )
	                {
	                 //   System.out.println("Last i "+i + " j " + j  );                
	                 //   map.put((i+":"+j),longCount);
	                    longestCount=longCount;
	                    longCount=0;
	                }
	                
	            }
	            
	            
	        }
	        
	       // System.out.println(map);
	        return longestCount;
	        
	        
	    }
	    int longCount=0;
	    public void longestIncreasingPathHelper(int[][] matrix, int row, int col, int tempMaxCount) {
	                    
	        
	        
	     //   System.out.println("**entered **");
	      
	       // checking current cell with all four side(left, right, top, bottom) and calling
	    	// recusion one for each time if criteria match which is next element should be greater then 
	    	// current cell elemet
	    	// Updating global variable for max value.
	                    if(col+1 < matrix[0].length &&  matrix[row][col] < matrix[row][col+1])
	                    {
	                       //  System.out.println("**1**");
	                        longestIncreasingPathHelper(matrix, row, col+1, tempMaxCount+1);
	                    
	                       
	                    }
	                    if(row-1 >= 0 && matrix[row][col] < matrix[row-1][col])
	                    {
	                      //  System.out.println("**2**");
	                       longestIncreasingPathHelper(matrix, row-1, col, tempMaxCount+1);
	                     
	                    }
	                    if(col-1 >= 0 && matrix[row][col] < matrix[row][col-1])
	                    {
	                      //  System.out.println("**3**");
	                        longestIncreasingPathHelper(matrix, row, col-1, tempMaxCount+1);
	                 
	                    }
	                    if(row+1 < matrix.length && matrix[row][col] < matrix[row+1][col] )
	                    {
	                       // System.out.println("**4**");
	                        longestIncreasingPathHelper(matrix, row+1, col, tempMaxCount+1);                      
	                
	                    }
	                 
	    //   System.out.println("**Exit ** tempMaxCount"+tempMaxCount + " longCount " + longCount); 
	        
	      
	            if(longCount < tempMaxCount)
	            {
	                longCount=tempMaxCount;
	            }
	  
	      
	     return;
	           
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingPath_in_A_Matrix329 l= new LongestIncreasingPath_in_A_Matrix329();
		
		
		// Working scenario and the output should be 4
		int  inputArr1[][]= {
			  {3,4,5},
			  {3,2,6},
			  {2,2,1}
			} ;
		
		System.out.println(l.longestIncreasingPath(inputArr1));
		
		// Time limit exceed scenario.
		int inputArr[][]= {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
		
		//System.out.println(l.longestIncreasingPath(inputArr));
	}

}
