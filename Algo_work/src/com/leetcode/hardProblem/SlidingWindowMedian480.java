package com.leetcode.hardProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/sliding-window-median/
 * 480. Sliding Window Median
Hard

557

58

Favorite

Share
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note:
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 * 
 * 
 */
/*class reversesort implements Comparator<Integer>
{
	
	public int compare(Integer a, Integer b) {
		
		return b-a;
	}
	
}*/

public class SlidingWindowMedian480 {

public double[] medianSlidingWindow(int[] nums, int k) {
     // Logic is maintain two heap -> max and min and maintain 1 element diff in length. 
	// if either one goes beyond range then rebalnce
        
        double result[]=new double[(nums.length-k)+1];
        int rcount=0;
        
        for(int i=0; i<(nums.length-k)+1; i++)
        {
            PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>( );
            PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new Comparator<Integer>(){
                 public int compare(Integer a, Integer b)
                   {
                       return b-a;
                   }
            });
            
            for(int j=i; j< (i+k) && j< nums.length; j++)
            {
                if(maxHeap.size() == 0 && minHeap.size() == 0 )
                {
                    maxHeap.add(nums[j]);
                    continue;
                }

                if(nums[j] > maxHeap.peek())
                {
                    minHeap.add(nums[j]);
                }
                else
                {
                    maxHeap.add(nums[j]);
                }

                int diff=Math.abs(minHeap.size()-maxHeap.size());

                if(diff > 1)
                {
                    hepify(minHeap,maxHeap);
                }
            }
          // System.out.println("MinHeap "+minHeap + " MaxHeap "+maxHeap);
            
            
            if(minHeap.size()== maxHeap.size())
            {
                //   System.out.println("********** inside");
                result[rcount++]= (minHeap.peek()*1.+ maxHeap.peek()*1.)/2.;
            }
            else
            {
                if(minHeap.size() > maxHeap.size())
                {
                    result[rcount++]=(double)minHeap.peek();
                }
                else
                {
                    result[rcount++]=(double)maxHeap.peek();
                }
            }
            
         //   System.out.println(Arrays.toString(result));
            
            
        }
        return result;
    }
    
    public void hepify(PriorityQueue minHeap,PriorityQueue maxHeap)
    {
        if(minHeap.size() > maxHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
        else if(maxHeap.size() > minHeap.size())
        {
            minHeap.add(maxHeap.poll());
        }
        
    }
    
    
    
    /*******************Second approach** more efficient and elegent************************/
    public double[] medianSlidingWindow1(int[] nums, int k) {
        // Logic is maintain two heap -> max and min and maintain 1 element diff in length. 
   	// if either one goes beyond range then rebalnce
           
           double result[]=new double[(nums.length-k)+1];
           int rcount=0;
           
           PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>( );
           PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new Comparator<Integer>(){
                public int compare(Integer a, Integer b)
                  {
                      return b-a;
                  }
           });
           
           for(int i=0; i<nums.length; i++)
           {
        	   addInHeap(maxHeap,minHeap,nums[i]);
        	   
        	   // if all k elements are part of heap then start removing
        	   if(i>= k)
        		   removeFromHeap(maxHeap,minHeap,nums[i-k]);
               
        	   // calculate running median for the kth elemet
        	   if(i >= k-1)
        		   result[rcount++]=calculateMedian(maxHeap,minHeap);
        		   
              
              System.out.println("MinHeap "+minHeap + " MaxHeap "+maxHeap);
               System.out.println(Arrays.toString(result));
               
               
           }
           return result;
       }
    
    public void addInHeap(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int num)
    {
    	if(max.size() == 0 && min.size() == 0 )
        {
            max.add(num);
            
        }
    	else
    	{
    		if(max.peek()!=null && num > max.peek())
            {
                min.add(num);
            }
            else
            {
                max.add(num);
            }
    	} 
    	
    	// finding difference and moving to heap
   	 	int diff=Math.abs(min.size()-max.size());

        if(diff > 1)
        {
            hepify(min,max);
        }
    	
    }
    
   
    public void removeFromHeap(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int num)
    {
    	boolean bool=max.remove(num) || min.remove(num);
    }
    
    
    
    public double calculateMedian(PriorityQueue<Integer> max, PriorityQueue<Integer> min)
    {
    	
    	
    	double result;
    	if(min.size()== max.size())
        {
            //   System.out.println("********** inside");
            result= (min.peek()*1.+ max.peek()*1.)/2.;
        }
        else
        {
            if(min.size() > max.size())
            {
                result=(double)min.peek();
            }
            else
            {
                result=(double)max.peek();
            }
        }
    	
    	return result;
    }
    
    
    
    /**********************************************/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindowMedian480 s= new SlidingWindowMedian480();
		
		int arr[]= {1,3,-1,-3,5,3,6,7};
		int k=3;
		
//		System.out.println(Arrays.toString(s.medianSlidingWindow(arr, k)));
//		System.out.println("*********************");
//		System.out.println(Arrays.toString(s.medianSlidingWindow1(arr, k)));
		
//
//		int arr1[]= {7,9,3,8,0,2,4,8,3,9};
//		System.out.println(Arrays.toString(s.medianSlidingWindow1(arr1, 1)));

//		int arr2[]= {5,5,8,1,4,7,1,3,8,4};
//		System.out.println(Arrays.toString(s.medianSlidingWindow1(arr2, 8)));
		
		
		
		int arr3[]= {2147483647,1,2,3,4,5,6,7,2147483647};
		System.out.println(Arrays.toString(s.medianSlidingWindow1(arr3, 2)));
	}

}
