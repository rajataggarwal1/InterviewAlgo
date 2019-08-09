package com.leetcode;
/*
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.

Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two (axis-aligned) rectangles, return whether they overlap.

Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Notes:

Both rectangles rec1 and rec2 are lists of 4 integers.
All coordinates in rectangles will be between -10^9 and 10^9.
 * 
 * 
 */
public class RectangleOverlap836 {

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
	      
        boolean isRectangle=false;
        
       // checking first condition for base case where rectangle inside boundry of first rectange
             if(rec2[0]>=rec1[0] || rec2[1]>=rec1[1] || rec2[2] >= rec1[2]  || rec2[3] >= rec1[3])
	            {
                
                    isRectangle=true;
                 // checking condition if rectange2 is total outside of first rectangel either out of upper bound or lower bound
                    if( rec2[0] >= rec1[2]  || rec2[1] >= rec1[3] || rec2[2] <= rec1[0] || rec2[3] <= rec1[1])
                    {
                        System.out.println("in side 2");
                         isRectangle=false;
                    }
	                
	            }
	            else
	            {
	                isRectangle=false;
	            }
        return isRectangle;
    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RectangleOverlap836 r=new RectangleOverlap836();
		/* result should false
		int[] rec1= {0,0,1,1};
		int [] rec2= {2,2,3,3}; */
		
		//int[] rec1= {};
		//int [] rec2= {};
		
		
		/* result should false
		int[] rec1= {-5,8,0,8};
		int [] rec2= {-5,4,5,5};*/
		
	
						/* result should true*/
						int[] rec1= {0,0,2,2};
						int [] rec2= {1,1,3,3};
		System.out.println(r.isRectangleOverlap(rec1,rec2));
		
		
		
	}

}
