package com.leetcode;
/*
 * https://leetcode.com/problems/complement-of-base-10-integer/
 * 1012. Complement of Base 10 Integer
Easy

25

9

Favorite

Share
Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.

The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.

For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.

 

Example 1:

Input: 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
Example 2:

Input: 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
Example 3:

Input: 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 

Note:

0 <= N < 10^9
 * 
 * 
 */
public class ComplementofBase10Integer1012 {
	 public int bitwiseComplement(int N) {
		// Create helper function which convert int into binary but it do in reverse order 
		        String str=intToBinaryInReverse(N);
		       
		        // Converting binary string into base of 10 to return in form of int.
		        int a=Integer.parseInt(str,2);
		       //   System.out.println(a);
		        
		     return a;   
		    }
		    

		// Function converting binary but it is placing 0 inplace of 1 and 1 inplace of 0 and return in string
		public String intToBinaryInReverse(int n)
			{
			    if(n==0)
		            return "1";
		    
		        String s = "";
			    while (n > 0)
			    {
			        s =  ( (n % 2 ) == 0 ? "1" : "0") +s;
			        n = n / 2;
			    }
			    return s;
			}
		
		// Another approach by other Leet code meetup people
		// This is good approach and i have to keep memorize
		 public int bitwiseComplementAnotherApproach(int N)
		 {
			  for(int i=0;i<35;i++){
			        //   System.out.println(i);
			            if(Math.pow(2,i)<=N && Math.pow(2,i+1)>N)
			              return((int)(Math.pow(2,i+1)-1)-N);  
			        }
			        
			        return 1;
		 }
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplementofBase10Integer1012 c=new ComplementofBase10Integer1012();
		System.out.println(c.bitwiseComplement(5));
		System.out.println(c.bitwiseComplement(7));
		System.out.println(c.bitwiseComplement(10));
		System.out.println(c.bitwiseComplement(0));
		
		System.out.println(c.bitwiseComplementAnotherApproach(5));
		System.out.println(c.bitwiseComplementAnotherApproach(7));
		System.out.println(c.bitwiseComplementAnotherApproach(10));
		System.out.println(c.bitwiseComplementAnotherApproach(0));
	}

}
