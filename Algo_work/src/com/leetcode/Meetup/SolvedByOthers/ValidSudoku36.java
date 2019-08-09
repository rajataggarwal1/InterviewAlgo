package com.leetcode.Meetup.SolvedByOthers;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
 * 
 * 
 * 
 */
public class ValidSudoku36 {
	public boolean isValidSudoku(char[][] board) {
		 
		   
	    ArrayList <HashSet<Integer>> vertical = new ArrayList<HashSet<Integer>>(9);
	    ArrayList <HashSet<Integer>> horizontal = new ArrayList<HashSet<Integer>>(9);
	    ArrayList <HashSet<Integer>> box = new ArrayList<HashSet<Integer>>(9);
	    for(int i =0; i< 9; i++){
	        vertical.add(new HashSet<Integer>());
	         horizontal.add(new HashSet<Integer>());
	        box.add(new HashSet<Integer>());
	    }
	    for (int i =0; i< 9; i++){
	        for(int j =0; j< 9; j++){
	           
	            if(board[i][j]!= '.'){
	            int num  = Character.getNumericValue(board[i][j]);
	            int k = 0*i+j;
	           
	            if(vertical.get(i).contains(num))
	                return false;
	            vertical.get(i).add(num);
	            if(horizontal.get(j).contains(num))
	                 return false;
	            horizontal.get(j).add(num);
	           
	            int index = findBox(i,j);
	            if(box.get(index).contains(num))
	                 return false;
	            box.get(index).add(num);
	            }
	        }
	    }
	     return true;
	    }
	       
	    int findBox( int i, int j){
	        int k = (i)/3;
	        int l = (j)/3;
	        return 3*k+ l;  
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidSudoku36 vs=new ValidSudoku36();
	}

}
