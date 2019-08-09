package com.DailyCoadingProblem;
/*
 * 
 * This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 * 
 * 
 * 
 */


public class StairCaseProblem {
	
	
	// Function when you can climb only 1 or 2 steps
	public static int uniqueWaysToClimb(int noOfSteps)
	{
		int ways=0;
		
		
		if (noOfSteps >= 1)
		{
			int prev=0;
			int next=1;
			for (int i=1; i<= noOfSteps;i++)
			{
				
				ways= prev+next;
				prev=next;
				next=ways;
				
			}
		}
		
		return ways;
	}
	
	// Function when you can climb n steps at time and n steps to climb
	
	public static int uniqueWaysToClimbNandN(int stepsCombinations, int noOfSteps)
	{
		int ways=0;
	//	int totalConbination=stepsCombinations.length;
		
		int res[] = new int[noOfSteps]; 
        res[0] = 1; res[1] = 1; 
        for (int i=2; i<noOfSteps; i++) 
        { 
           res[i] = 0; 
           for (int j=1; j<=stepsCombinations && j<=i; j++) 
             res[i] += res[i-j]; 
        } 
        return res[noOfSteps-1]; 
        
	}
		
		
	
	
	public static void main(String [] args)
	{
		int output=0;
				
		output = uniqueWaysToClimb(0);
		System.out.println("No of unique combination : "+output);
		
		output = uniqueWaysToClimb(1);
		System.out.println("No of unique combination : "+output);
		
		output = uniqueWaysToClimb(4);
		System.out.println("No of unique combination : "+output);
		
		output = uniqueWaysToClimb(5);
		System.out.println("No of unique combination : "+output);
		
		output = uniqueWaysToClimb(6);
		System.out.println("No of unique combination : "+output);
		
		output = uniqueWaysToClimb(7);
		System.out.println("No of unique combination : "+output);
		
		
		
		
		
		}

}
