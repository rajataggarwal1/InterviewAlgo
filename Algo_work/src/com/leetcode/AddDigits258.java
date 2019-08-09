package com.leetcode;
/*
 * 258. Add Digits
Easy

423

756

Favorite

Share
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 * 
 * 
 * 
 */
public class AddDigits258 {
	// my accepted solution
	public int addDigits(int num) {
        
	       // Run loop till num is greater then 9 because we have to return in single digit 
	        while(num>9)
	        {
	            int mod=num%10;
	            int div=num/10;
	            
	             num=mod+div;           
	        
	        }
	        
	        return num;
	    }
	
	// Followup question and I think interviewer is looking O(1) solution
	//https://en.wikipedia.org/wiki/Digital_root
	public int addDigits_O1(int num) {
		return (1 + (num - 1) % 9);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddDigits258 a=new AddDigits258();
		
		System.out.println(a.addDigits(15));
		System.out.println(a.addDigits_O1(94));
	}

}
