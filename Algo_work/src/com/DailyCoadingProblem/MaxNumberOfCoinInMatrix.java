package com.DailyCoadingProblem;
/**
 * Daily Coding Problem: Problem #122 [Medium]
Inbox
x

Daily Coding Problem <founders@dailycodingproblem.com> Unsubscribe
9:14 AM (10 hours ago)
to me

Good morning! Here's your coding interview problem for today.

This question was asked by Zillow.

You are given a 2-d matrix where each cell represents number of coins in that cell. Assuming we start at matrix[0][0], and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.

For example, in this matrix

0 3 1 1
2 0 0 4
1 5 3 1
The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.
 * 
 * 
 * 
 * 
 * @author rajat
 *
 */
public class MaxNumberOfCoinInMatrix {
public static int maxCoinCount(int[][] coins)
{
	
	for(int i=0; i< coins.length; i++)
	{
		
		
		for(int j=0; j<coins[0].length; j++)
		{
			
			if(i!=0 && j!=0)
			{
				coins[i][j]=coins[i][j]+ Math.max(coins[i-1][j], coins[i][j-1]);
			}
			else if(i==0 && j!=0)
			{
				coins[i][j]=coins[i][j]+coins[i][j-1];
			}
			else if(j==0 && i!=0)
			{
				coins[i][j]=coins[i][j]+coins[i-1][j];
				
			}
			
		}
	}
	
	
	return coins[coins.length-1][coins[0].length-1];
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] coins= {{0, 3, 1, 1},{2,0,0,4},{1,5,3,1}};
		System.out.println(maxCoinCount(coins));
		
	}

}
