package com.DailyCoadingProblem;

import java.util.Arrays;

/*
 * This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */


public class ArrayProduct {

	public static int[] calculateArrIndexProduct(int arr[])
	{
		int size=arr.length;
		int productArr[]=new int[size];
		int product=1;
		
		
		
		for (int i=0; i<size; i++)
		{
			product=1;
			
			for (int j=0;j<size; j++)
			{
				//without using divide function
				if (i==j)
				{
					continue;
				}
				else
				{
					product=product*arr[j];
				}
				productArr[i]=product;
			}
				
		}
		
		
		return productArr;
	}
	
	
	public static void main(String [] args)
	{
		
		int arr1[]= {1,2,3,4,5,6};
		int arr2[]= {1,2,3,4,5};
		int arr3[]= {3,2,1};
		int arr4[]= {1,2,3};
		int arr5[]= {1};
		int arr[]= {1,2};
		
		
		int outputArr[]= calculateArrIndexProduct(arr);
		
		for (int i=0; i<outputArr.length;i++)
		{
			System.out.println(outputArr[i]);
		}
		
		
		
		
		}
}
