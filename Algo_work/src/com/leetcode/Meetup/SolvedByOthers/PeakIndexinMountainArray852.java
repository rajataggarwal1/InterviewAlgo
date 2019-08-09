package com.leetcode.Meetup.SolvedByOthers;
/**
 * 
 * 852. Peak Index in a Mountain Array
Easy

229

526

Favorite

Share
Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1
Example 2:

Input: [0,2,1,0]
Output: 1
Note:

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.
Accepted
57,922
Submissions
83,959
 * 
 * @author rajat
 *
 */
public class PeakIndexinMountainArray852 {
	public int peakIndexInMountainArray(int[] A) {
        int len = A.length;
 
        int peak = 0;;
        for (int i=1; i< len; i++)
            if(A[i]>A[peak])
                peak =i;
            else
                break;
        return peak;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PeakIndexinMountainArray852 p=new PeakIndexinMountainArray852();
		
		int [] arr= {0,2,1,0};
		
		System.out.println(p.peakIndexInMountainArray(arr));
		
	}

}
