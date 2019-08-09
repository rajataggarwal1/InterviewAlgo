package com.searchSort;

import java.util.Arrays;

public class BinarySearch {

	
	public static int binaryS(int arr[], int keyTofind)
	{
		Arrays.sort(arr);
		int min= 0;
		int max=arr.length-1;
		
		int index= binarySearchNumber(arr, min,max,keyTofind);
				
		return index;
	}
	
	
	// Searching input number using binary serach recursion
	
	public  static int binarySearchNumber(int arr[], int min,int max, int keyTofind)
	{
		if(max >= min){
			
			int mid= (min+max)/2;
			
			if (arr[mid] == keyTofind)
				return mid;
			if (arr[mid] > keyTofind)
			{
				return binarySearchNumber(arr, min,mid-1,keyTofind);
			}
				
		if (arr[mid] < keyTofind )
			{
				return binarySearchNumber(arr, mid+1,max,keyTofind);
			}
			
			
		}
			
		
		
		
	 return -1;
	}
	
	// Searching input number using binary serach loop
	
	public static int binarySLoop(int arr[], int keyTofind)
	{
		Arrays.sort(arr);
		int min= 0;
		int max=arr.length-1;
		
		int index= binarySearchNumberLoop(arr, min,max,keyTofind);
				
		return index;
	}
	public  static int binarySearchNumberLoop(int arr[], int min,int max, int keyTofind)
	{
		while(max >= min){
			
			int mid= (min+max)/2;
			
			if (arr[mid] == keyTofind)
				
				return mid;
			if (arr[mid] > keyTofind)
			{
				max=mid-1;
				
			}
				
		if (arr[mid] < keyTofind )
			{
			min= mid+1;
				
			}
			
			
		}
			
		
		
		
	 return -1;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= { 1,7,8,15,20,22,30};
		
		
		System.out.println("Number found at : "+ binaryS(arr, 15));
		System.out.println("Number found at : "+ binaryS(arr, 22));
		System.out.println("Number found at : "+ binaryS(arr, 55));
		
		System.out.println("----------loop----------");
		System.out.println("Number found at : "+ binarySLoop(arr, 15));
		System.out.println("Number found at : "+ binarySLoop(arr, 22));
		System.out.println("Number found at : "+ binarySLoop(arr, 55));
		
		int arr1[]= { 1,7,7};
		System.out.println("Number found at : "+ binaryS(arr1, 7));
		System.out.println("----------loop----------");
		System.out.println("Number found at : "+ binarySLoop(arr1, 7));
		
		
		int arr2[]= { 1};
		System.out.println("Number found at : "+ binaryS(arr2, 15));
		System.out.println("Number found at : "+ binaryS(arr2, 1));
		
		System.out.println("----------loop----------");
		System.out.println("Number found at : "+ binarySLoop(arr2, 15));
		System.out.println("Number found at : "+ binarySLoop(arr2, 1));
		
	}

}
