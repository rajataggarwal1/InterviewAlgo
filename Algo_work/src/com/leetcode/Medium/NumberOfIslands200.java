package com.leetcode.Medium;
/*
 * https://leetcode.com/problems/number-of-islands/
 * 200. Number of Islands
Medium

3137

109

Favorite

Share
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 * 
 */

public class NumberOfIslands200 {

public int numIslands(char[][] grid) {
        
        // O(n) space and O(n) time complexicity
        
        int totalIsland=0;
        
        if(grid.length ==0)
            return totalIsland;
        
        
        int visited[][]=new int[grid.length][grid[0].length];
        
        for(int i=0; i< grid.length; i++)
        {
            
            for(int j=0; j< grid[0].length; j++)
            {
                if(visited[i][j]==-1 || grid[i][j]=='0')
                {
                    continue;
                    
                }
                
                // if pass above condition then one island found so increase the counter
                totalIsland++;
                // Set visited as soon as found first starting point 
                visited[i][j]=-1;
                // Helper function calling recursivly to complete one island iteration
                numIslandsHelper(grid,visited, i, j);
                
            }
            
        }
         //System.out.println(Arrays.deepToString(visited));
        
        return totalIsland;
    }
    
    // This is core logic check left , right, top and bottom in one go if it has similar value
    // update the visited array and keep checking if visited or not before recursivly calling for 
    // next level. Set visited to -1 as soon as condition satisfied.
    public void numIslandsHelper(char grid[][], int visited[][], int row, int col)
    {
        
        // left
        if(col-1 >=0 && visited[row][col-1]!=-1 && grid[row][col-1] == '1')
        {
             visited[row][col-1]=-1;
            numIslandsHelper(grid,visited, row, col-1);
            
        }        
        //right
         if(col < grid[0].length-1 && visited[row][col+1]!=-1 && grid[row][col+1] == '1')
        {
             visited[row][col+1]=-1;
            numIslandsHelper(grid,visited, row, col+1);
            
        }         
            
            //top
        if(row-1 >=0 && visited[row-1][col]!=-1 && grid[row-1][col] == '1')
        {
             visited[row-1][col]=-1;
            numIslandsHelper(grid,visited, row-1, col);
            
        }  
        
            //Bottom
         if(row < grid.length-1 && visited[row+1][col]!=-1 && grid[row+1][col] == '1')
        {
             visited[row+1][col]=-1;
            numIslandsHelper(grid,visited, row+1, col);
            
        }
        
        return;
        
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfIslands200 n=new NumberOfIslands200();
		
		char[][] island = { { '1', '0', '0', '1', '1' }, 
				{ '0', '1', '0', '0', '0' }, 
				{ '1', '0', '1', '0', '0' },
				{ '1', '0', '0', '1', '1' } }; // expected result 6
		
		System.out.println("No of Island : "+n.numIslands(island));
		
		char[][] island2 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		System.out.println("No of Island : "+n.numIslands(island2)); // expected result 1
		
		//edge condition
		char[][] island3 = {};
		System.out.println("No of Island : "+n.numIslands(island3)); // expected result 1
	}

}
