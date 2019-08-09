package com.DailyCoadingProblem;

/*
 * This problem was asked by Amazon.

Implement a stack that has the following methods:

push(val), which pushes an element onto the stack
pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.

*** below max function is important which will go thru array and find the max value in the array.
max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
 * 
 * 
 * */


public class Stack {

	/**
	 * @param args
	 */
		
	static int pos=-1;
	static final int size=10;
	static int arr[]= new int[size];
	static int maxValArr[]= new int[size];
	
	public static int pop()
	{
		if (pos==-1)
			return pos;
		else
		{			
			return arr[pos--];
			
		}
	}
	
	public static void push(int i)
	{
		if(pos==size)
		{
			System.out.println("Stack is full. Item canot be inserted");
		}
		else
		{
			arr[++pos]=i;
			
			if(pos==0)
			{
				maxValArr[pos]=i;
			}
			else
			{
				if( i > maxValArr[pos-1])
				{
					maxValArr[pos]=i;
				}
				else
				{
					int temp= maxValArr[pos-1];
					maxValArr[pos-1] = i;
					maxValArr[pos]=temp;
				}
			}

		}
	}
	
	public static int max()
	{
		if(pos==-1)
			return pos;
		else
		{
			return maxValArr[pos];
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int maxVal= max();
		
		System.out.println("Max Value" +max() );
		System.out.println("pop Value" +pop() );
		
		push(10);
		push(11);
		
		System.out.println("pop Value" +pop() );
		
		push(7);
		push(5);
		push(3);
		
		System.out.println("Max Value" +max() );
		System.out.println("pop Value" +pop() );
		System.out.println("pop Value" +pop() );
		push(5);
		push(3);
		System.out.println("Max Value" +max() );
		System.out.println("pop Value" +pop() );
		
		System.out.println("Max Value" +max() );
		
		
		System.out.println(maxValArr );
		System.out.println(arr);
	}

}
