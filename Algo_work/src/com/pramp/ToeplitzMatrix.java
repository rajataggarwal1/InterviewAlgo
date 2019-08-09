package com.pramp;
/*
 * Toeplitz Matrix
A Toeplitz matrix is a matrix where every left-to-right-descending diagonal has the same element. Given a non-empty matrix arr, write a function that returns true if and only if it is a Toeplitz matrix. The matrix can be any dimensions, not necessarily square.

For example,

[[1,2,3,4],
 [5,1,2,3],
 [6,5,1,2]]
is a Toeplitz matrix, so we should return true, while

[[1,2,3,4],
 [5,1,9,3],
 [6,5,1,2]]
isn’t a Toeplitz matrix, so we should return false.

Constraints:

[time limit] 5000ms
[input] array.array.integer arr
0 ≤ arr.length ≤ 20
0 ≤ arr[i].length ≤ 20
0 ≤ arr[i][j] ≤ 20
[output] boolean

 * 
 * 
 * 
 */

/*Solution discussion*/
/*
 * /*
  i=j  - check the element 
  
  row <= col
  i=0, j=0 --> 11 -> 22
  i=0, j=1 -> 12 -> 23 
  02 -> 13
  03
  --
  
  
  10 -> 21
  20, 
  
  
  //outer loop for starting points i=00, 01, 02..0col
      for traversing the diagonl..
  
  */
 

public class ToeplitzMatrix {
	static boolean isToeplitz(int[][] arr) {
		// your code goes here
    
    // Outer loop for row
    int col=0;
    while(col<arr[0].length)
    {
      int tempval=arr[0][col];
      for(int i=0,j=col; i< arr.length && j < arr[0].length ; i++, j++)
      {
      //logic to traverse diagonally
        if(tempval != arr[i][j])
           return false;
      }
     col++;
    }
    
    int row=1;
    while(row<arr.length)
    {
      int tempval=arr[row][0];
      for(int i=row,j=0; i< arr.length && j < arr[0].length ; i++, j++)
      {
      //logic to traverse diagonally
        if(tempval != arr[i][j])
           return false;
      }
     row++;
    }
    
    return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ToeplitzMatrix tl=new ToeplitzMatrix();
		int arr[][]= {{1,2,3,4},{5,1,2,3},{6,5,1,2}};
		System.out.println("result " +isToeplitz(arr) );
		
		int arr1[][]= {{1,2,3,4},{5,1,9,3},{6,5,1,2}};
		System.out.println("result " +isToeplitz(arr1) );
	}

}
