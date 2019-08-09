package com.leetcode.Meetup.SolvedByOthers;
/*
 * 633. Sum of Square Numbers
Easy

298

208

Favorite

Share
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
 

Example 2:

Input: 3
Output: False
 * 
 * 
 */
public class SumofSquareNumbers633 {

	// Below is the real burtforece solution which has o(n2) complexcity
	public boolean judgeSquareSum(int c) {
        for(long i=0 ;i*i<=c;i++){
            for(long  j=0;j*j<=c;j++){
                if((i*i+j*j)==c){
                    return true;
                }
               
            }
        }
        return false;
    }
	
	// another solution is bit better
	private boolean isPerfectSquare(int n)
    {
        if(n < 0)
            return false;
   
        int root= (int) (Math.sqrt(n));
       
        return n == root * root;
    }

	public boolean judgeSquareSum1(int c) {
        int i = 0;
       
        while((i * i) <= c)
        {
            int x = c - (i * i);
           
            if(isPerfectSquare(x))
                return true;
           
            i++;
        }
       
        return false;
    }

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumofSquareNumbers633 squar=new SumofSquareNumbers633();
		
		System.out.println("squar is "+ squar.judgeSquareSum(9));
		System.out.println("2squar  is "+ squar.judgeSquareSum1(9));
	}

}
