package com.leetcode;
/*
 * given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [-231,  231 - 1]. For the purpose of this problem, assume that your function returns 231 -1 when the division result overflows.
 * 
 * 
 */

public class DivideTwoInteger {

	
	public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        boolean divisorSign = true;
        boolean dividendSign = true;
        if(divisor < 0){
            divisorSign = false;
            divisor = divisor*-1;
        }
        if(dividend < 0){
            dividend = dividend *-1;
            dividendSign = false;
        }
        int quotient = 0;
        while(dividend - divisor >= 0){
            dividend  = dividend - divisor;
            quotient++;
            if(quotient < 0) return Integer.MAX_VALUE;
        }
        if(!dividendSign && !divisorSign) return quotient;
        if(!dividendSign || !divisorSign) return quotient*-1;
        return quotient;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoInteger di=new DivideTwoInteger();
			int quotient=	di.divide(10, 3);
			
			System.out.print(quotient);
	}

}
