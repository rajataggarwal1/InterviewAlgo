package com.leetcode;

public class EvenOddSorting {

	public int[] evenOddSort(int[] arr) {
		if(arr.length==0)
		{
			return arr;			
		}
		
		int tempArr[]= new int[arr.length];
		
		int evenCount=0;
		int oddCount=0;
		for(int i=0; i< arr.length; i++)
		{
			if(arr[i]%2 == 0)
			{
				evenCount++;
				
			}else
			{
				oddCount++;   
			}
		}
		
		int arrLength=arr.length;
		if(evenCount == arrLength || oddCount ==arrLength)
		{
			return arr;		
		}
		
		
		// Using extra space. fill odd and even  for even start from the position where first even going to be inserted. Need to maintain the order.
		int i=0;
		int j=0;
		while(evenCount !=0 || oddCount!=0 )
		{
			if(arr[i]%2 == 0)
			{
				tempArr[arrLength-evenCount]=arr[i++];
				evenCount--;
				
			}else
			{
				tempArr[j++]=arr[i++];
				oddCount--;
			}
		}
		return tempArr;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EvenOddSorting even=new EvenOddSorting();
		
		// Expected out put -> All odd on left and all even on right and order should maintain.
		//int arr[]= {1,21,3,7,9,10,11}; // maximum odd
		//int arr[]= {}; // null input
		//int arr[]= {1,21,3,7,9,5,11}; // all odd
	//	int arr[]= {2,21,4,8,12,5,30}; // maximum even
		
	//	int arr[]= {2,14,4,8,12,0,30}; // all even
		//int arr[]= {2,5,4,9,12,1,30,31}; // equal
		
		int arr[]= {2,3}; // 
		
		int returnArr[]=even.evenOddSort(arr);
		
		for(int i=0; i< returnArr.length; i++)
		{
			System.out.print(returnArr[i] + ", ");
		}
		
		
		
		
		

	}

}
