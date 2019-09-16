package com.Practice.Qtest;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
/*
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2
 *  are also in arr1. Sort the elements of arr1 such that the relative ordering of items in arr1 are
 *  the same as arr2. Elements that don't appear in arr2 should be placed at the end of
 *   arr1 in ascending order. Time Limit: 30 minutes, 200 points
 *   Example: Input: arr1=[2,3,1,3,2,4,6,7,9,2,19], arr2= [2,1,4,3,9,6]
 *   Constraints:
 *   -arr1.length, arr2.length<=1000,  0<=arr1[i], arr2[i] <=1000
 *   -Each arr2[i] is distinct. Each arr2[i] is in arr1
 * 
 * 
 */

/* sort two Array arr1 and arr2 and maintain the order*/

// complexicity is O(n*m) -> n is the length of first array and M is the length of second array
// Space O(n) -> using hashMAp to get the count.

public class SortTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortTwoArray sr=new SortTwoArray();
		
		int arr1[]= {2,3,1,3,2,4,6,7,9,2,19};
		int arr2[]= {2,1,4,3,9,6};
		
		
		
		System.out.println(Arrays.toString(sr.sortTwoArraywithOrder(arr1, arr2)));
		
		int arr3[]= {};
		int arr4[]= {2,1,4,3,9,6};
		
		System.out.println(Arrays.toString(sr.sortTwoArraywithOrder(arr3, arr4)));
		
		int arr5[]= {2,3,1,3,2,4,6,7,9,2,19};
		int arr6[]= {};
		
		System.out.println(Arrays.toString(sr.sortTwoArraywithOrder(arr5, arr6)));
		
	}
	
	
	public int[] sortTwoArraywithOrder(int [] arr1, int [] arr2)
	{
		
		if(arr1.length ==0)
		{
			return arr1;
		}
		
		
		
		TreeMap<Integer, Integer> map=new TreeMap<Integer, Integer>();
		
		// iterating array and finding the total element
		for(int i=0; i< arr1.length; i++)
		{
			if(map.containsKey(arr1[i]))
			{
				int cnt=map.get(arr1[i]);
				cnt+=1;
				map.put(arr1[i], cnt);
				
			}
			else
			{
				map.put(arr1[i], 1);
			}
			
		}
		
		
		// Building result array
		int resultArr[]= new int[arr1.length];
		int k=0;
		if(arr2.length>0)
		{
			for(int j=0; j< arr2.length; j++)
			{
				
				if(map.containsKey(arr2[j]))
				{
					int cnt=map.get(arr2[j]);
					while(cnt>0)
					{
						resultArr[k++]=arr2[j];		
						cnt--;
					}
					map.remove(arr2[j]);
					
				}
			}
		}
		
		// loop for remaining element
		
		
		for(Map.Entry<Integer, Integer> entries:map.entrySet())
		{
			
			int cnt=entries.getValue();
			while(cnt>0)
			{
				resultArr[k++]=entries.getKey();		
				cnt--;
			}
			
		}
		
		return resultArr;
		
		
	}

}
