package com.leetcode.Meetup.SolvedByOthers;
/*https://leetcode.com/problems/surrounded-regions/
 * 
 * 130. Surrounded Regions
Medium

639

388

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
 * 
 */
public class SurroundedRegions130 {
	public void solve(char[][] board) {
	       
        if(board.length< 3 || board[0].length<3)
            return ;
         for (int i=0; i< board.length; i++){
            dfsConnected(i,0,board);
            dfsConnected(i,board[0].length-1,board);
         }
       
        for (int i=0; i< board[0].length; i++){
            dfsConnected(0,i,board);
            dfsConnected(board.length-1,i,board);
         }
       
         for (int i=0; i< board.length; i++){
              for (int j=0; j< board[0].length; j++){
                  if(board[i][j] == 'O')
                      board[i][j] = 'X';
                   if(board[i][j] == 'Z')
                       board[i][j] = 'O';
              }
         }
    }
       
       
   
    void dfsConnected (int row, int col, char[][] board){
        if(row<0 || row>=board.length || col<0 || col>= board[0].length || board[row][col]=='X' || board[row][col]=='Z'){
            return;
        }
        board[row][col] = 'Z';
        dfsConnected(row-1, col, board);
        dfsConnected(row+1, col, board);
        dfsConnected(row, col-1, board);
        dfsConnected(row, col+1, board);
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
