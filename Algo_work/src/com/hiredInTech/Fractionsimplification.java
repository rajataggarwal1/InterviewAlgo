package com.hiredInTech;
/*
 * https://www.hiredintech.com/classrooms/algorithm-design/lesson/23/task/20/solution
 * Task: Fraction simplification
An operation very often performed on fractions is simplification to lowest terms. If a fraction has numerator N and denominator D, then it is simple if N and D don’t have any common divisors other than 1. Otherwise, the fraction can be simplified to “lower terms” meaning that there is another fraction with the same value where the numerator and denominator are smaller numbers than N and D.

Here are a few examples:

The fraction 3/7 cannot be simplified because 3 and 7 don’t have any common divisors other than 1. The fraction 8/24 on the other hand, can be simplified to 1/3.

Write a function, which given two integers - the numerator and denominator of a fraction returns the simplified fraction, possibly the same one as in the input. To return the result the function will receive a third parameter - a list of two elements in which you need to store the resulting numerator and denominator in this order. In all programming languages the list supplied will have two elements allocated that you need to fill with values.

The integers N and D will be in the range [1, 1,000,000,000].

Here is a sample test case:

SAMPLE INPUT

77 22
SAMPLE OUTPUT

7 2
 * 
 * 
 * 
 */
public class Fractionsimplification {

	/**
	 * @param args
	 */
	
	public static void simplify_fraction(int numerator, int denominator, int[] result) {
        // Write your code here
        // result[0] = ...
        // result[1] = ...
        
                
    
       int num1,num2;
       if(numerator>denominator)
       {
           num1=numerator;
           num2=denominator;
       }
       else
       {
            num1=denominator;
            num2=numerator;
       }
       //this is called Euclidean algorithm
       while(num2>0)
       {
           int temp=num2;
           num2=num1%num2;
           num1=temp;
       }
       
       result[0]=numerator/num1;
       result[1]=denominator/num1;
        System.out.println( result[0]);
        System.out.println( result[1]);
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		simplify_fraction(24,8,new int[2]);
		simplify_fraction(77,22,new int[2]);
	}

}
