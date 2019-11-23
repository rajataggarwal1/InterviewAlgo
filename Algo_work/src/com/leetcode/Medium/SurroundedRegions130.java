package com.leetcode.Medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/surrounded-regions/
 * 130. Surrounded Regions
Medium

Favorite

Share
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * 
 * 
 */

public class SurroundedRegions130 {
public void solve(char[][] board) {
        
        // Logic is to convert 'o' to x when it is not adjoining to edge or any 'o' not adjoin to other edge
        // created visited array where I am tracking all the linked 'O' on edge 
        // by going thru array in recursion where i check row+1, row-1, col+1 and col-1
        // and then go tru the array and conver all non visited which are not -1 to X
       
        
        // return if board is blank
        if(board.length ==0)
            return;
        
        // visited array
        int visited[][]=new int[board.length][board[0].length];
        
        int row=board.length-1;
        int col=board[0].length-1;
        
        for(int i=0; i< board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            { 
                if(visited[i][j] == -1 || board[i][j]=='X')
                {                     
                    continue;
                }
                 // Going thru to all linked edge which has 'O' and mark them as visited because
                // we do not need to convert them in X                
                if((i==0 && board[i][j] == 'O') || (j==0 && board[i][0] == 'O') || (i==row && board[i][j] =='O') || (j==col && board[i][j]=='O'))
                {                  
                    visited[i][j]=-1;
                   // Going into recursion                    
                    flipToX(i,j,board,visited);                      
                } 
                
              // System.out.println(Arrays.deepToString(board));
               // System.out.println(Arrays.deepToString(visited));
            }            
        }
        
        // Finally going thru array and leaving visited and conver all remaining 0 to X
        for(int i=0; i< board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(visited[i][j] == -1 || board[i][j]=='X')
                {                     
                    continue;
                }                
                board[i][j]='X';                
            }
        }
             
    }
    
    // Recursion helper method
    public void flipToX(int row, int col, char [][] arr, int visited[][])
    {
        
        //top
        if(row-1>=0 && visited[row-1][col] !=-1 && arr[row-1][col]=='O')
        {
            visited[row-1][col]=-1;           
            flipToX(row-1,col,arr,visited);            
        }  
        //bottom
        if(row+1<arr.length && visited[row+1][col] !=-1 && arr[row+1][col]=='O')
        {
            visited[row+1][col]=-1;          
            flipToX(row+1,col,arr,visited);            
        } 
        
        //left    
       
        if(col-1 >=0 && visited[row][col-1] !=-1 && arr[row][col-1]=='O')
        {
            visited[row][col-1]=-1;            
            flipToX(row,col-1,arr,visited);            
        }         
        
        //right
       if(col+1<arr[0].length && visited[row][col+1] !=-1 && arr[row][col+1]=='O')
        {
            visited[row][col+1]=-1;          
            flipToX(row,col+1,arr,visited);            
        }         
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegions130 s=new SurroundedRegions130();
		
		char board[][]= {{'O','O','X','X','O'},{'O','O','X','O','X'},{'O','X','O','X','X'},{'O','O','O','O','X'}				
		};			
		s.solve(board);		
		System.out.println(Arrays.deepToString(board));
		
		char board1[][]= {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}				
		};
		s.solve(board1);		
		System.out.println(Arrays.deepToString(board1));
	}

}
