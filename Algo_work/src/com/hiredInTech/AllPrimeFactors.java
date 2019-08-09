package com.hiredInTech;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.hiredintech.com/classrooms/algorithm-design/lesson/23/task/30
 * Task: All prime factors
Given an integer N, for which 2 <= N <= 10^12, find its prime factors. The result must be a list of sorted prime numbers where each number is listed as many times as it is present in the prime decomposition of N.

Here are a few examples to make this clear:

For N=20 the prime decomposition is 20 = 2 * 2 * 5, so you must return 2, 2, 5.

For N=64 the prime decomposition is 64 = 2 * 2 * 2 * 2 * 2 * 2, result must be 2, 2, 2, 2, 2, 2.

For N=1105 the prime decomposition is 1105 = 5 * 13 * 17, result must be 5, 13, 17.

For N=9901 the prime decomposition consists of the number 9901 itself, so the result must be a list with one element 9901 (9901 is a prime number).

You must write a function, which accepts one parameter - the number N and returns the list of sorted prime numbers in the prime decomposition of N.
 * 
 */
public class AllPrimeFactors {
	
	// Solution copied from tutorial
	public static List<Long> all_prime_factors(long number) {
		List<Long> result = new ArrayList<Long>();
	    for (int i = 2; i <= Math.sqrt(number); i++) {
	        while (number%i == 0)
	        {
	            result.add((long)i);
	            number = number/i;
	        }
	    }

	    if (number != 1) {
	        result.add(number);
	    }

	    return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(all_prime_factors(10));
System.out.println(all_prime_factors(20));
System.out.println(all_prime_factors(64));
System.out.println(all_prime_factors(1105));
System.out.println(all_prime_factors(9901));

	}

}
