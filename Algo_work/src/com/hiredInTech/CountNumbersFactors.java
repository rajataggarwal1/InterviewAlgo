package com.hiredInTech;
/*
 * https://www.hiredintech.com/classrooms/algorithm-design/lesson/23/task/22
 * Task: Count number's factors
This is a classic task requiring you to count all integer factors of a positive integer number N, including 1 and the number itself. Note that this is not just about the prime factors but all of them.

For example for 12 there are 6 such factors: 1, 2, 3, 4, 6, 12.

In this task N will be in the range [1, 10^12].

Your function will receive one argument - the number N. It must return one integer - the number of all factors of N as described above.

Here is an example test case:

SAMPLE INPUT

12
SAMPLE OUTPUT

6
 * 
 * 
 */
public class CountNumbersFactors {
	public static int count_numbers_factors(long number) {
        // Write your code here    
	
		if(number==0)
			return 0;
		if(number==1)
			return 1;
		
		long num=number/2;
		
		int count=1;
		while(num>1)
		{
			if(number%num==0)
			{
				count++;
			}
			num--;
		}
		count++;
		
		return count;
		
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count_numbers_factors(12));
		System.out.println(count_numbers_factors(10));
		System.out.println(count_numbers_factors(15));
		System.out.println(count_numbers_factors(100000));
		System.out.println(count_numbers_factors(47));
	}

}
