package com.byteByByte;





public class MatrixProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixProduct mp= new MatrixProduct();
		int arr[][] ={{1,2,3},
				{4,5,6},
				{7,8,9}};
		
		System.out.println("Maximum subproduct in array is "+mp.calculateMaxMatrixProduct(arr));
		int arr1[][] ={{-1,2,3},
				{4,5,-6},
				{7,8,9}};
		
		System.out.println("Maximum subproduct in array is "+mp.calculateMaxMatrixProduct(arr1));
		
	}
	
	public int calculateMaxMatrixProduct(int arr[][])
	{
		
		if(arr.length == 0)
		{
			return 0;
		}
		if(arr[0].length == 0)
		{
			
		}
		
		// calculating product using dynamic programming
			
		int dp[][]=new int[arr.length][arr[0].length];
		dp[0][0] = arr[0][0];
		
		// populating first row
		for(int i=1; i< arr.length; i++)
		{
			dp[0][i] = arr[0][i] * dp[0][i-1];			
		}
		
		// populating first column
		for(int j=1; j<arr[0].length; j++)
		{
			dp[j][0] = arr[j][0] * dp[j-1][0];		
			
		}
		
		for(int i=1; i< arr.length; i++)
		{
			for(int j=1; j<arr[0].length; j++)
			{
				// calulating max of i-1(row before) and j-1(column above)
				dp[i][j] = Math.max(arr[i][j] * dp[i-1][j], arr[i][j] * dp[i][j-1]);
			}
		}
		
		// printing DP table
		for(int i=0; i< arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				// calulating max of i-1(row before) and j-1(column above)
				System.out.print(dp[i][j]+" , ");
			}
			System.out.println();
		}
		
		return dp[arr.length-1][arr[0].length-1];
		
	}
	
	
	
	

}
