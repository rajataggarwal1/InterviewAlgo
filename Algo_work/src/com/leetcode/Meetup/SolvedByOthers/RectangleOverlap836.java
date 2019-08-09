package com.leetcode.Meetup.SolvedByOthers;
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
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int a1 = rec2[0], b1 = rec2[1], a2 = rec2[2], b2 = rec2[3];
        return (!(a1 >= x2  || b1 >= y2 || a2 <= x1 || b2 <= y1));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RectangleOverlap836 r=new RectangleOverlap836();
		int[] rec1= {0,0,1,1};
		int [] rec2= {2,2,3,3};
		
		//int[] rec1= {};
		//int [] rec2= {};
		
		System.out.println(r.isRectangleOverlap(rec1,rec2));
		
		
		
	}
}
