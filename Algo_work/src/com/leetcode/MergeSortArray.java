package com.leetcode;
/*
 * 88. Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 * 
 * 
 * 
 */
public class MergeSortArray {
	

public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int totalLength=(m+n)-1;
        int mainArrLength=m-1;
        int subArrLen=n-1;
        
        
        
        if(m==0)// Checking if m is not have any element, Copy whole nums2
        {
        	
        	for(int i=0; i< n ; i++)
        	{
        		nums1[i]=nums2[i];
        	}
        }
        else if( n > 0) // checking n >0 because if num2 has element and nums1 is also have elemet. We do not care false condition.
        	// it means nums1 is teh correct array.
        {
		     while(totalLength >= 0)
		      {
		        if(nums1[mainArrLength]> nums2[subArrLen])
		        {
		            
		            nums1[totalLength]=nums1[mainArrLength];
		            mainArrLength--;
		            totalLength--;
		            if(mainArrLength==-1)
		            	break;
		           
		            //
		        }
		        else //if(nums1[mainArrLength]<= nums2[subArrLen])
		        {
		             nums1[totalLength]=nums2[subArrLen];
		            subArrLen--;
		            totalLength--;
		            if(subArrLen==-1)
		            	break;
		        }
		        
		      }
      
		      //while(mainArrLength>=0)
		     while(totalLength>=0) // copying all element from one array to nums1 if either nums1 or nums2 finished early.
		      {
		    	  if(subArrLen==-1)
		    		  nums1[totalLength--]=nums1[mainArrLength--];
		    	  else if (mainArrLength==-1)
		    	  {
		    		  nums1[totalLength--]=nums2[subArrLen--];
		    	  }
		      }
        }
        
      
      for(int i=0;i<(m+n);i++)
    	  System.out.print(nums1[i]);
      
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MergeSortArray mr=new MergeSortArray( );
		/*int arr1[]={1,2,3,0,0,0};
		int arr2[]={2,5,6};
		mr.merge(arr1, 3,arr2,3);*/
		
		int arr1[]={0};
		int arr2[]={2};
		mr.merge(arr1, 0,arr2,1);
			
	}

}
