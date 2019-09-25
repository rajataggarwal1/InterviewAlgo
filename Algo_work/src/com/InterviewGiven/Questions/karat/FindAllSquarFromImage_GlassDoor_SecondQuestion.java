package com.InterviewGiven.Questions.karat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

The image you get is known to have potentially many distinct rectangles of 0s on a background of 1s. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

image1 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [0, 1, 1, 0, 0, 0, 1],
  [1, 0, 1, 0, 0, 0, 1],
  [1, 0, 1, 1, 1, 1, 1],
  [1, 0, 1, 0, 0, 1, 1],
  [1, 1, 1, 0, 0, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

Sample output:
findRectangles(image1) =>
  // (using top-left and bottom-right):
  [
    [[0,0],[0,0]],
    [[2,0],[2,0]],
    [[2,3],[3,5]],
    [[3,1],[5,1]],
    [[5,3],[6,4]],
    [[7,6],[7,6]],
  ]

*/

public class FindAllSquarFromImage_GlassDoor_SecondQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindAllSquarFromImage_GlassDoor_SecondQuestion s=new FindAllSquarFromImage_GlassDoor_SecondQuestion();
		 int[][] image1 = {
			      {0, 1, 1, 1, 1, 1, 1},
			      {1, 1, 1, 1, 1, 1, 1},
			      {0, 1, 1, 0, 0, 0, 1},
			      {1, 0, 1, 0, 0, 0, 1},
			      {1, 0, 1, 1, 1, 1, 1},
			      {1, 0, 1, 0, 0, 1, 1},
			      {1, 1, 1, 0, 0, 1, 1},
			      {1, 1, 1, 1, 1, 1, 0},
			      
			    };
		 
		 int[][] image2 = {
			      {0, 0, 1, 0, 1, 0, 0},
			      {1, 1, 1, 1, 1, 0, 0},
			      {0, 1, 1, 0, 1, 0, 0},
			      {1, 0, 1, 0, 1, 0, 0},
			      {1, 0, 1, 1, 1, 1, 1},
			      {1, 0, 1, 0, 0, 1, 1},
			      {1, 1, 1, 0, 0, 1, 1},
			      {0, 0, 0, 1, 1, 1, 0},
			      
			    };
		 
		// output [0,0,0,1], [0,3,0,3], [0,5,3,6],[2,0,2,0], [2,3,3,3], [3,1,5,1], [5,3,6,4], [7,0,7,2], [7,6,7,6]
		 
		System.out.println(s.findAllSquar(image1));
		System.out.println(s.findAllSquar(image2));

	}
	
	
	public List<List<Integer>> findAllSquar(int[][] image)
	{
		
		List<List<Integer>> returnList=new ArrayList<List<Integer>>();
		
		//List<Integer> lst=new ArrayList<Integer>();
		
		
		int visited[][]=new int[image.length][image[0].length];
		
		
		boolean isFirstZero=false;
		
		for(int i=0; i< image.length; i++)
		{
			isFirstZero=false;
			for(int j=0; j< image[0].length; j++)
			{
				if(image[i][j]==1)
				{
					isFirstZero=false;
					continue;
				}
				
				if(!isFirstZero && image[i][j]==0)
				{
					List<Integer> lst=new ArrayList<Integer>();
					if(visited[i][j]!=-1)
					{
						lst.add(i);
						lst.add(j);
						returnList.add(lst);
					}
					
					visited[i][j]=-1;
					if(i+1< image.length-1 && image[i+1][j]==0)
					{
						visited[i+1][j]=-1;
					}
					
					isFirstZero=true;
					continue;
				}
				
			}
		}
		
		
		System.out.println(Arrays.deepToString(visited));
		
		
		// iterating from bottom left to top right and keep checking first zero and store int List
		int visited1[][]=new int[image.length][image[0].length];
		int len=returnList.size()-1;
		
		for(int i=image.length-1; i>= 0; i--)
		{
			isFirstZero=false;
			for(int j=image[0].length-1; j>=0; j--)
			{					
				if(image[i][j]==1)
				{
					isFirstZero=false;
					continue;
				}
				
				if(!isFirstZero && image[i][j]==0)
				{
					List<Integer> lst=returnList.get(len);
					if(visited1[i][j]!=-1)
					{
						lst.add(i);
						lst.add(j);
						returnList.set(len,lst);
						len--;
					}
					
					visited1[i][j]=-1;
					if(i-1 >= 0 && image[i-1][j]==0)
					{
						visited1[i-1][j]=-1;
					}
					
					
					
					isFirstZero=true;
					continue;
				}
				
			}
		}
		
		
		System.out.println(Arrays.deepToString(visited));
		
		
		
		
		
		return returnList;
		
		
		
	}
	
	
	
	

}
