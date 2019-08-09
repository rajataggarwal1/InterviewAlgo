package com.leetcode;
/*
 * https://leetcode.com/problems/spiral-matrix-ii/
 * 59. Spiral Matrix II
Medium

408

75

Favorite

Share
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * 
 * 
 */
public class SpiralMatrix_II_59 {
public int[][] generateMatrix(int n) {
        
        int returnArr[][]=new int[n][n];
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        
        int inserCount=1;
        
        while(left<=right)
        {
            // top row loop
            for(int j=left; j<=right; j++)
            {
                returnArr[top][j]=inserCount++;
            }
             top++;
               
            // column last
            for(int i=top; i<=bottom; i++)
            {
                returnArr[i][right]=inserCount++;
            }
            right--;
            
            
            // bottom row
             for(int j=right; j>=left; j--)
            {
                returnArr[bottom][j]=inserCount++;
            }
            bottom--;
                               
            // left column
            
            for(int j=bottom; j>=top; j--)
            {
                returnArr[j][left]=inserCount++;
            }
            left++;
            
        }
       
        return returnArr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix_II_59 spr=new SpiralMatrix_II_59();
		
		int returnArr[][]=spr.generateMatrix(3);
		
		for(int i=0; i<returnArr.length;i++ )
		{
			for(int j=0; j< returnArr[0].length; j++)
			{
				System.out.print(returnArr[i][j] + " , ");
			}
			System.out.println();
		}
		
	}

}
