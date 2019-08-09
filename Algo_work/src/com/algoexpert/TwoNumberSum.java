package com.algoexpert;

/**
 * 
 * https://www.algoexpert.io/questions/Two%20Number%20Sum
 * @author rajat
 *
 */


public class TwoNumberSum {

	 public static int[] twoNumberSum(int[] array, int targetSum) {
		    
			int count=array.length;
			int resultArr[]=new int[2];
			int numtoCheck=0;		
			boolean sumFound=false;
			for(int i=0; i< count; i++)
			{
				numtoCheck=targetSum-array[i];
				for(int j=i+1; j<count; j++)
				{
					if(array[j]== numtoCheck)
					{
						if(array[j]>array[i])
						{
							resultArr[0]=array[i];
							resultArr[1]=array[j];
						}
						else
						{
							resultArr[0]=array[j];
							resultArr[1]=array[i];
						}
						sumFound=true;
						break;
					}
					
				}
			}
		
			if(sumFound)
				return resultArr;
			else
			return new int[0];
			
	  }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int arr[]= {3,5,-4,8,11,1,-1,6};

		//int arr[]= {4,6};
		
		int arr[]= {3,5,-4,8,11,1,-1,6};
		
		int result[]=twoNumberSum(arr,15);
		
		for(int i=0;i<result.length;i++)
		{
			System.out.println(result[i]);
		}
		
		
	}

}
