package com.InterviewGiven.Questions;

/**
 * 
 * // Given a board and an end position for the player, write a function to determine if it is possible to travel from every open cell on the board to the given end position.

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
		
		return false;
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

	    int[] end = new int[] {0, 0};
	    
	    
	    System.out.println(i.isReachable(board1,end));
	    System.out.println(i.isReachable(board2,end));
	    System.out.println(i.isReachable(board3,end));
		
	 // Expected output:

	 // isReachable(board1, end) -> True
	 // isReachable(board2, end) -> False
	 // isReachable(board3, end) -> False
	}

}
