package com.leetcode.hardProblem;
/*
 * 84. Largest Rectangle in Histogram
Hard

2494

64

Favorite

Share
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10
 * 
 * 
 */
public class LargestRectangleInHistogram84 {
public int largestRectangleArea(int[] heights) {
        
        // Going thru each element and using sliding window patterrn
        // Assign max ractange as first element then keep checking with its next and previous
        // If greater then current then keep expanding until found lesser element
        // repeate same steps again for next element.
        // keep updating maxsofar
        
	// Another approach can be using stack.
	
         int maxsofar=0;
        if(heights.length > 0)
             maxsofar=heights[0];
      
        
        for(int i=0; i< heights.length; i++)
        {
            int first=i-1;
            int second=i+1;
            int curr=heights[i];
            
            int total=curr;
            
           while((first>=0 && heights[first] >= curr) || (second< heights.length && heights[second] >= curr))
            {               
                if(first>=0 && heights[first]>=curr)
                {                  
                    total+=curr;                      
                    first--;
                }
                if(second< heights.length && heights[second]>=curr)
                {
                     total+=curr;  
                    second++;
                }                
            }
            
            if(maxsofar<total)
            {
                maxsofar=total;
            }
            
        }
       
        return maxsofar;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleInHistogram84 l=new LargestRectangleInHistogram84();
		
		int []heights= {2,1,5,6,2,3};
		
		System.out.println(l.largestRectangleArea(heights));
		
		
	}

}
