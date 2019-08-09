package com.leetcode;

public class BestTimetoBuyandSellStock122 {

	/**
	 * @param args
	 * 
	 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
	 */
	
	public int maxProfit(int[] prices) {
		 int length= prices.length;
	        int profit=0;
	        int totalProfit=0;
	        int trnscount=0;
	        int stockBuy=0;
	        
	        // Checking base condition
	        if(length<=0)
	            return 0;
	        else if(length == 2 ) // we can have two condition if length is two.
	        {
	            if(prices[0] < prices[1])
	                return prices[1]- prices[0];
	            else
	                return 0;
	        }
	        else
	        {
	            // Outer loop rum length -1 to compare with next element
	            for(int i=0; i<length-1; i++)
	            {
	                
	                if(prices[i] < prices[i+1])
	                {
	                    stockBuy=prices[i];
	                    trnscount++;
	                    
	                    //innerloop start with next element and calculate best time to sell
	                   for(int j=i+1; j<length; j++)
	                    {
	                       if(prices[j] > stockBuy)
	                       {
	                           profit=prices[j]-stockBuy;
	                           
	                           if(j==length-1 || prices[j+1] < prices[j])
	                           {
	                               trnscount--;
	                               break;
	                           }
	                           
	                       }
	                       // setting i to the value where j left
	                       i=j;
	                    }
	                    
	                    if(trnscount ==0)
	                    totalProfit = totalProfit+profit;
	                   
	                }
	                
	            }
	            
	            return totalProfit;
	             
	        }
       
       
    }
	// DP solution taken from discussion O(N) time and O(n) space
	/*
	 * TAble
	 * Hold[] = -7,-1,-1,1,1,3
	 * Sold[] = 0,0,4,4,7,7
	 * 
	 * 
	 * 
	 */
	
	public int maxProfitDP(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        int[] hold = new int[n];
        int[] sold = new int[n];
        hold[0] = -prices[0];
        sold[0] = 0;
        for(int i = 1; i < n; i++) {
             hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
             sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i]);
        }
        return sold[n- 1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStock122 b= new BestTimetoBuyandSellStock122();
		
		int arr[]={7,1,5,3,6,4};
		
		
		System.out.println(b.maxProfit(arr));
		System.out.println(b.maxProfitDP(arr));
		
		int arr1[]={1,2,3,4,5};
		
		
		System.out.println(b.maxProfit(arr1));
		System.out.println(b.maxProfitDP(arr1));
	}

}
