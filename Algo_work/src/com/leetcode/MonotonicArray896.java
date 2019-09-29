package com.leetcode;
/*
 * 896. Monotonic Array
Easy

352

28

Favorite

Share
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.

 

Example 1:

Input: [1,2,2,3]
Output: true
Example 2:

Input: [6,5,4,4]
Output: true
Example 3:

Input: [1,3,2]
Output: false
Example 4:

Input: [1,2,4,5]
Output: true
Example 5:

Input: [1,1,1]
Output: true
 

Note:

1 <= A.length <= 50000
-100000 <= A[i] <= 100000
 */
public class MonotonicArray896 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonotonicArray896 m=new MonotonicArray896();
		int arr[] = {1,2,2,3};
		System.out.println(m.isMonotonic(arr));
		
		int arr1[] = {6,5,4,4};
		System.out.println(m.isMonotonic(arr1));
		
		int arr2[] = {1,3,2};
		System.out.println(m.isMonotonic(arr2));
		
		int arr3[] = {1,2,4,5};
		System.out.println(m.isMonotonic(arr3));
		
		int arr4[] = {1,1,1};
		System.out.println(m.isMonotonic(arr4));
		
	}
	
	public boolean isMonotonic(int[] A) {
        
        int increasing=0;
        int decreasing=0;
        int duplicate=0;
        
       // check the value and keep increment incres/decrease and duplicate counter
        // Finally check by summing up with dup+incre/decrea to return result.
        for(int i=0; i< A.length-1; i++)
        {            
            if(A[i]< A[i+1])
            {
                increasing++;
            }
            else if(A[i]> A[i+1])
            {
                decreasing++;
            }
            else
            {
                duplicate++;
            }
            
        }
        
      //  System.out.println("increasing " + increasing + " decreasing " + decreasing + " duplicate " + duplicate);
        
        if(((increasing +duplicate) == A.length-1) ||(( decreasing+duplicate) == A.length-1))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}
