package com.DailyCoadingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.
 * 
 */

public class PowerSetToSet {
	
	public void addNode(Node head,Node newNode)
	{
		Node temp=head;
		
		if(head == null)
		{
			head=newNode;
		}
		else
		{
			newNode.next=temp;
			head.next=newNode;
		}		
	}

	
	public List calculateSetFromPowerSet(int set[])
	{
		int set_size= set.length;
		List list= new ArrayList();
		
		/*set_size of power set of a set 
        with set_size n is (2**n -1)*/
        long pow_set_size =  
            (long)Math.pow(2, set_size); 
        int counter, j; 
      
        /*Run from counter 000..0 to 
        111..1*/
        for(counter = 0; counter <  
                pow_set_size; counter++) 
        { 
            for(j = 0; j < set_size; j++) 
            { 
                /* Check if jth bit in the  
                counter is set If set then  
                print jth element from set */
                if((counter & (1 << j)) > 0) 
                    System.out.print(set[j]); 
            } 
              
            System.out.println(); 
        } 
		
		return list;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int arr[]= {1,2,3};
		int arr[]= {1,2};
		
		PowerSetToSet ps= new PowerSetToSet();
		List lst=ps.calculateSetFromPowerSet(arr);
		
		for(int i=0;i<lst.size();i++)
		{
			//int resultArr[]=lst.toArray(lst.get(i) );
			System.out.print(lst.get(i));
		}
		
	}
	
	public class Node
	{
		int value[];
		Node next;
		Node()
		{
			this.next=null;			
		}
	}

}
