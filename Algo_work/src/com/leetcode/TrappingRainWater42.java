package com.leetcode;
/*
 * 42. Trapping Rain Water
Hard

3052

53

Favorite

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 * 
 * 
 */
public class TrappingRainWater42 {
	public int trap(int[] height) {
        int size=height.length;
        int leftMax[]=new int[size];
        int rightMax[]=new int[size];
        
        int tempLMax=0;
        
        // First loop to findout the max from left
        for(int i=0; i<size;i++)
        {
            int topHeight=height[i];
            leftMax[i]=tempLMax;
            
            tempLMax=Math.max(tempLMax,topHeight);
            
        }
        
         // second loop to findout the max from left
        int tempRMax=0;
        
        for(int i=size-1; i>=0;i--)
        {
            int topHeight=height[i];
            rightMax[i]=tempRMax;
            
            tempRMax=Math.max(tempRMax,topHeight);
            
        }
       
        // Calculating water fill area and sum
         int sum=0;
        for(int i=0; i<size;i++)
        {
            int minHeight=Math.min(leftMax[i],rightMax[i]);
            if( height[i] < minHeight)
            {
                height[i]=minHeight-height[i];
            }
            else
            {
                 height[i]=0;
            }
           sum=sum+ height[i]; // Calculating sum
        }
      
        
        return sum;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater42 tr=new TrappingRainWater42();
		
		int arr[]= {0,1,0,2,1,0,1,3,2,1,2,1};
		
		
		System.out.println("water traped   "+tr.trap(arr));
	}

}
