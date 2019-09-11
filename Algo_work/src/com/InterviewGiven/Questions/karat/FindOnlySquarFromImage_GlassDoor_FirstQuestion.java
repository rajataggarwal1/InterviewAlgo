package com.InterviewGiven.Questions.karat;

import java.util.Arrays;

/*
 * 
 * 

Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

Write a function that takes in the image and returns one of the following representations of the rectangle of 0's: top-left coordinate and bottom-right coordinate OR top-left coordinate, width, and height.

int[][] image1 = {
  {1, 1, 1, 1, 1, 1, 1},
  {1, 1, 1, 1, 1, 1, 1},
  {1, 1, 1, 0, 0, 0, 1},
  {1, 1, 1, 0, 0, 0, 1},
  {1, 1, 1, 1, 1, 1, 1}
};


Sample output variations (only one is necessary):

findRectangle(image1) =>
  x: 3, y: 2, width: 3, height: 2
  2,3 3,5 -- row,column of the top-left and bottom-right corners

Other test cases

image2 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

findRectangle(image2) =>
  x: 6, y: 4, width: 1, height: 1
  4,6 4,6

image3 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 0, 0],
  [1, 1, 1, 1, 1, 0, 0],
]

findRectangle(image3) =>
  x: 5, y: 3, width: 2, height: 2
  3,5 4,6
  
image4 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

findRectangle(image4) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0

image5 = [
  [0],
]

findRectangle(image5) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0
  
 * 
 * 
 * 
 * 
 */
public class FindOnlySquarFromImage_GlassDoor_FirstQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] image1 = {
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 0, 0, 0, 1},
			      {1, 1, 1, 0, 0, 0, 1},
			      {1, 1, 1, 1, 1, 1, 1}
			    };

			    int[][] image2 = {
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 1, 0}
			    };

			    int[][] image3 = {
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 0, 0},
			      {1, 1, 1, 1, 1, 0, 0}
			    };

			    int[][] image4 = {
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 1, 1},
			      {0, 0, 1, 1, 1, 1, 1},
			      {0, 0, 1, 1, 1, 1, 1}
			    };

			    int[][] image5 = {
			      {0}
			    };

			    // call function for question one
			    // print results
			    
			    
			    FindOnlySquarFromImage_GlassDoor_FirstQuestion s=new FindOnlySquarFromImage_GlassDoor_FirstQuestion();
			     System.out.println(Arrays.toString(s.findRect(image1)));
			     System.out.println(Arrays.toString(s.findRect(image2)));
			     System.out.println(Arrays.toString(s.findRect(image3)));
			     System.out.println(Arrays.toString(s.findRect(image4)));
			     System.out.println(Arrays.toString(s.findRect(image5)));
				
				System.out.println("********************");
			     
			     System.out.println(Arrays.toString(s.findRectNew(image1)));
			     System.out.println(Arrays.toString(s.findRectNew(image2)));
			     System.out.println(Arrays.toString(s.findRectNew(image3)));
			     System.out.println(Arrays.toString(s.findRectNew(image4)));
			     System.out.println(Arrays.toString(s.findRectNew(image5)));
			     
		

	}
	// Optimized solution going from left to right to get location of first 0 and then going from bottom right to top to get last location of zero
	public int[] findRectNew(int [][] image)
	  {
	    
	    int retArray[]=new int[4];
	    
	    boolean firstFound=false;
	    
	    for(int i=0; i< image.length; i++)
	    {
	    	
	    	for(int j=0; j< image[0].length; j++)
	    	{
	    		if(image[i][j]==0)
	    		{
	    			 retArray[0]=i;
	   		      retArray[1]=j;
	   		   firstFound=true;
	   		      break;
	    		}
	    	}
	    	
	    	if(firstFound)
	    	{
	    		break;
	    	}
	    }
	    
	    
	    
	    // find  last zero from last row to first row
	    firstFound=false;
	    for(int i=image.length-1; i>=0; i--)
	    {
	    	
	    	for(int j=image[0].length-1; j>=0; j--)
	    	{
	    		
	    		if(image[i][j]==0)
	    		{
	    			 retArray[2]=i;
	   		      retArray[3]=j;
	   		      firstFound=true;
	   		      break;
	    		}
	    		
	    	}
	    	if(firstFound)
	    	{
	    		break;
	    	}
	    	
	    }
	    
	    return retArray;
	    
	    
	  }
	
	public int[] findRect(int [][] image)
	  {
	    
	    int retArray[]=new int[4];
	    
	    if(image.length ==0)
	    {
	      
	    }
	    
	    
	    // to go over the array
	int count=0;
	for(int i=0; i< image.length; i++)
	{
	  
	  for(int j=0; j<image[0].length; j++)
	  {
	    
	    if(image[i][j]==1)
	    {
	      continue;
	    }
	    
	    
		if(image[i][j]==0)
		{
		  if(count==0)
		  {
		      retArray[0]=i;
		      retArray[1]=j;
		  }       
		  
		  count++;
		  
		  if(itsEnd(image, i,j) ||  i== image.length-1 || j== image[0].length-1)
		  {
			 retArray[2]=i;
			 retArray[3]=j;
	      }
		      
	    }
		    
		    
		    
	  }
		  
		  
	}
	    
	    return retArray;
	      
	    
	    
	  }
	  
	  
	  
	public boolean itsEnd(int [][]image, int row, int col)
	{
	       
		if((row <= image.length-2 && image[row+1][col] == 1 )&& (row <= image.length-2 && col <= image[0].length-2 &&  image[row+1][col+1]==1) && (col <= image[0].length-2 &&image[row][col+1]==1))
		{
		  return true;
		}
		else
		{
		  return false;
		}
	      
	}

}
