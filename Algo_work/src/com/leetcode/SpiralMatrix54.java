package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 54. Spiral Matrix
Medium

927

361

Favorite

Share
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */
public class SpiralMatrix54 {

public List<Integer> spiralOrder(int[][] inputMatrix) {
        
        int row=0;
    int col=0;
    int rowMin=0;
    int colMin=0;
    int rowMax=inputMatrix.length-1;
    int colMax=inputMatrix[0].length-1;
    ArrayList returnList=new ArrayList();
    
      while(colMin <= colMax && rowMin <= rowMax)
      {
     //   if(colMin <=colMax)
       // {
            
          for(col=colMin; col<=colMax; col++)
          {
            returnList.add(inputMatrix[rowMin][col]);
          }
          rowMin++;
      //  }
       // if(rowMin <= rowMax)
        //{
            for(row=rowMin; row<=rowMax;row++)
            {
                returnList.add(inputMatrix[row][colMax]);
           
            }
             colMax--;
      //  }
        
        if(colMax>=colMin)
        {
          for(col=colMax; col>=colMin; col--)
          {
            returnList.add(inputMatrix[rowMax][col]);
          }
          rowMax--;  
        }
          
        if(rowMax>=rowMin)
        {
         for(row=rowMax; row>=rowMin;row--)
          {
             returnList.add(inputMatrix[row][colMin]);
          }
           colMin++;
        }
        
        
       
       
      }
    
  //  int returnArr[]=new returnArr[returnList.size()];
 //   returnArr=returnList.toArray();
        return returnList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int twoDArray1[][]={{0,1,2,3},
				{4,5,6,7},
				{8,9,10,11},
				{12,13,14,15}};
		
		
		int twoDArray2[][]={{0,1,2,3,50},
				{4,5,6,7,60},
				{8,9,10,11,70},
				{12,13,14,15,80}};
		
		int twoDArray[][]={{1,2},
				{3,4},
				{5,6}};
		
	//	sample output : 12,13,14,15,80,70,60,50,3,2,1,0,4,5,6,7,11,10,9,8,
		
		
		int twoDArray3[][]={{},
				{1}
				};
		
		int twoDArray5[][]={{0,1,2},
				{4,5,6},
				{8,9,10}};
		
		SpiralMatrix54 s=new SpiralMatrix54();
		
		ArrayList list1=(ArrayList) s.spiralOrder(twoDArray5);
		
		for (int i=0; i<list1.size(); i++)
		{
			System.out.print(list1.get(i) + ",");
		}
	}
	

}
