package com.leetcode;

import java.util.Arrays;

/**
 * 322. Coin Change
Medium

1409

66

Favorite

Share
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 * 
 * @author rajat
 *
 */
public class CoinChange322 {
	
public int coinChange(int[] coins, int amount) {
        
        Arrays.sort(coins);
        int tempAmount=amount;
        int count=0;
        
       // if(coins.length <=1 && coins[0] < amount)
        //    return -1;
            
           // int i=coins.length-1;
            
                
                for(int i=coins.length-1; i>=0 && tempAmount >= 0;  i--)
                {
                    while(true)
                    {
                    if(tempAmount >= coins[i])
                    {
                        tempAmount=tempAmount-coins[i];
                        count++;
                        continue;
                    
                    }
                    else
                    {
                        break;
                    }
                
                
                    }
                
                }
            
            if(tempAmount==0)
            {
                return count;
            }
        else
            return -1;
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange322 c=new CoinChange322();
		//int coins[]= {1,2,5};
		int coins[]= {1};
	//	System.out.println(c.coinChange(coins,2));
		
		int count=101;
		int modc=100;
		
		
		while(count>0)
		{
			count=count/10;
			//System.out.println("divide - "+count);
			//modc=modc/10;
			count=count%10;
			
			System.out.println("mod -"+count);
			
		}
		
		 toString(modc);
		 
		
		
	}

}
