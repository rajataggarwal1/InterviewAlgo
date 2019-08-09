package com.hiredInTech;
/*
 * https://www.hiredintech.com/classrooms/algorithm-design/lesson/23/task/28
 * Task: Sum the divisors
Given an integer n, calculate the sum of all divisors of n.

For example, the divisors of 8 are 1,2,4 and 8 and 1 + 2 + 4 + 8 = 15 The divisors of 7 are 1 and 7, which makes the sum 8.

The input number n will be in the range [1, 10^9].

Return one number - the sum of divisors of n.

Sample test examples
Input	Output
8	15
7	8
1	1
1000	2340

 * 
 * 
 */
public class SumTheDivisors {

	 public static long sum_the_divisors(int number) {
	        // Write your code here
		 if(number==0)
				return 0;
			if(number==1)
				return 1;
			
			long num=number/2;
			
			long sum=1;
			int iteration=0;
			while(num>1)
			{
				if(number%num==0)
				{
					//System.out.println(num);
					sum=sum+num;
				}
				iteration++;
				if(iteration==1)
				{
					num=num/2;
				}
				else
				{
					num--;
				}
				
				
			}
			
			sum=sum+number;
			
			return sum;
		 
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(sum_the_divisors(8));
System.out.println(sum_the_divisors(7));
System.out.println(sum_the_divisors(1));
System.out.println(sum_the_divisors(1000));
System.out.println(sum_the_divisors(2500));
	}

}
