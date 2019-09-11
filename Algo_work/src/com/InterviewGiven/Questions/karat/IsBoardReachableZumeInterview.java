package com.InterviewGiven.Questions.karat;

import java.util.Arrays;

/**
 * 
 * // Given a board and an end position for the player, write a function to determine if it is possible to travel from every open cell on the board to the given end position.
-1 is wall . You cannot move beyod this
// board1 = [
//     [ 0,  0,  0, 0, -1 ],
//     [ 0, -1, -1, 0,  0 ],
//     [ 0,  0,  0, 0,  0 ],
//     [ 0, -1,  0, 0,  0 ],
//     [ 0,  0,  0, 0,  0 ],
//     [ 0,  0,  0, 0,  0 ],
// ]

// board2 = [
//     [  0,  0,  0, 0, -1 ],
//     [  0, -1, -1, 0,  0 ],
//     [  0,  0,  0, 0,  0 ],
//     [ -1, -1,  0, 0,  0 ],
//     [  0, -1,  0, 0,  0 ],
//     [  0, -1,  0, 0,  0 ],
// ]

// board3 = [
//     [ 0,  0,  0,  0,  0,  0, 0 ],
//     [ 0, -1, -1, -1, -1, -1, 0 ],
//     [ 0, -1,  0,  0,  0, -1, 0 ],
//     [ 0, -1,  0,  0,  0, -1, 0 ],
//     [ 0, -1,  0,  0,  0, -1, 0 ],
//     [ 0, -1, -1, -1, -1, -1, 0 ],
//     [ 0,  0,  0,  0,  0,  0, 0 ],
// ]

// end = (0, 0)

// Expected output:

// isReachable(board1, end) -> True
// isReachable(board2, end) -> False
// isReachable(board3, end) -> False


        int[][] board1 = new int[][] {
        { 0,  0,  0, 0, -1 },
        { 0, -1, -1, 0,  0 },
        { 0,  0,  0, 0,  0 },
        { 0, -1,  0, 0,  0 },
        { 0,  0,  0, 0,  0 },
        { 0,  0,  0, 0,  0 },
    };

    int[][] board2 = new int[][] {
        {  0,  0,  0, 0, -1 },
        {  0, -1, -1, 0,  0 },
        {  0,  0,  0, 0,  0 },
        { -1, -1,  0, 0,  0 },
        {  0, -1,  0, 0,  0 },
        {  0, -1,  0, 0,  0 },
    };

    int[][] board3 = new int[][] {
        { 0,  0,  0,  0,  0,  0, 0 },
        { 0, -1, -1, -1, -1, -1, 0 },
        { 0, -1,  0,  0,  0, -1, 0 },
        { 0, -1,  0,  0,  0, -1, 0 },
        { 0, -1,  0,  0,  0, -1, 0 },
        { 0, -1, -1, -1, -1, -1, 0 },
        { 0,  0,  0,  0,  0,  0, 0 },
    };

    int[] end = new int[] {0, 0};

    
  
 * 
 * 
 * 
 * 
 * 
 *
 */
public class IsBoardReachableZumeInterview {

	public boolean isReachable(int [][] board, int startCordinate[])
	{
		// creating Replica of origional array to update traverse value eachtime move to the cell
		
		int visited[][]=new int [board.length][board[0].length];
		visited=board;
		
		// Setting start position as 1 because from here we have started traversing so this will be treated as visited
		visited[0][0]=1;
		isReachableHelper(board, startCordinate[0] , startCordinate[1],  visited);
		
		
		// Printing
		System.out.println(Arrays.deepToString(visited));
		
		// Traversing DP to see if any 0 remaining. if yes then we cannot traverse all the element and return false
		for(int i=0; i< visited.length; i++)
		{
			for(int j=0; j<visited[0].length; j++)
			{				
				if(visited[i][j]==0)
				{
					
					return false;
				}
				
			}
					
		}
		
		// If all one in dp array then return true
		return true;
	}
	
	public void isReachableHelper(int [][] board, int row , int col, int visited[][])
	{
		
		// Going in all direction and simaltanously checking whether that cell is visited or not.
		// if not visited then traverse and set visited array as 1 else return from resurcion call
		
		//left
		if(col-1 >= 0 && board[row][col-1] != -1 && visited[row][col-1]==0)
		{
			visited[row][col-1]=1;
			isReachableHelper(board, row , col-1,visited);
		}
		//right
		if(col+1 < board[0].length &&   board[row][col+1] != -1 && visited[row][col+1]==0 )
		{
			 visited[row][col+1]=1;
			isReachableHelper(board, row , col+1, visited);
		}
		
		//bottom
		if(row+1 < board.length && board[row+1][col] != -1  && visited[row+1][col]==0)
		{
			visited[row+1][col]=1;
			isReachableHelper(board, row+1 , col,visited);
		}
		
		
		//top
		if(row-1 >= 0 && board[row-1][col] != -1  && visited[row-1][col]==0)
		{
			visited[row-1][col]=1;
			isReachableHelper(board, row-1 , col, visited);
		}
		
		
		
		return ;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IsBoardReachableZumeInterview i=new IsBoardReachableZumeInterview();
		
		
		
		int[][] board1 = new int[][] {
	        { 0,  0,  0, 0, -1 },
	        { 0, -1, -1, 0,  0 },
	        { 0,  0,  0, 0,  0 },
	        { 0, -1,  0, 0,  0 },
	        { 0,  0,  0, 0,  0 },
	        { 0,  0,  0, 0,  0 },
	    };
	    
	    
	    int[][] board2 = new int[][] {
	        {  0,  0,  0, 0, -1 },
	        {  0, -1, -1, 0,  0 },
	        {  0,  0,  0, 0,  0 },
	        { -1, -1,  0, 0,  0 },
	        {  0, -1,  0, 0,  0 },
	        {  0, -1,  0, 0,  0 },
	    };

	    int[][] board3 = new int[][] {
	        { 0,  0,  0,  0,  0,  0, 0 },
	        { 0, -1, -1, -1, -1, -1, 0 },
	        { 0, -1,  0,  0,  0, -1, 0 },
	        { 0, -1,  0,  0,  0, -1, 0 },
	        { 0, -1,  0,  0,  0, -1, 0 },
	        { 0, -1, -1, -1, -1, -1, 0 },
	        { 0,  0,  0,  0,  0,  0, 0 },
	    };

	   // int[] end = new int[] {0, 0};
	    //int[] end = new int[] {1, 0};
	    int[] end = new int[] {3, 3};
	    
	    System.out.println(i.isReachable(board1,end));
	   System.out.println(i.isReachable(board2,end));
	    System.out.println(i.isReachable(board3,end));
		
	 // Expected output:

	 // isReachable(board1, end) -> True
	 // isReachable(board2, end) -> False
	 // isReachable(board3, end) -> False
	}

}
