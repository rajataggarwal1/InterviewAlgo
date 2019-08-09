package com.hiredInTech;
/*
 * https://www.hiredintech.com/classrooms/algorithm-design/lesson/23/task/32
 * Task: Prime counting
A classic math task is to count the prime numbers less than or equal to some integer number N. In this task you have to write a function, which does this for a given N, where 1 <= N <= 10^6. We don't count 1 a prime.

Here are a few examples:

For N=10, the prime numbers, which are less than or equal to 10 are: 2, 3, 5, 7. The function must return 4. For N=31, the prime numbers are: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31. The function must return 11.
 * 
 */
public class PrimeCounting {
	public static int prime_counting(int n) {
	    // Write your code here
	    
	    int primeCount=0;
	    
	    for(int i=2; i<= n; i++)
	    {
	        boolean primeFlag=true;
	        for(int j=2; j< i ; j++)
	        {
	            if(i%j==0)
	            {
	                primeFlag=false;
	                break;
	            }
	            
	            
	        }
	        if(primeFlag==true)
            {
                System.out.print(i +",");
                primeCount++;
            }
	    }
	    
	    return primeCount;
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(prime_counting(10));
		System.out.println(prime_counting(31));
	}

}
