package com.DailyCoadingProblem;

import java.util.HashMap;
import java.util.Scanner;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * 
 *  * @author RAgarwal
 *This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

 */



public class IntersectingNode {
	
	/**
	 * @param args
	 */
	public Node head;
	public Node tail;
	
	 class Node{
		public int val;
		public Node next;
		
		public Node(int val)
		{
			this.val=val;
			this.next=null;
		}
	}
	

	
	public IntersectingNode()
	{
		this.head=null;
		this.tail=null;
	}
	
	public  Node findIntersectingNode(Node list1Head, Node list2Head)
	{
		Node linkList = new Node(0);
		Node temp1 = list1Head;
		Node temp2= list2Head;
		HashMap map= new HashMap();
		
		//Iterating first list and adding value in hashmap so that we can iterate second list and check value init for intersection
		while(temp1!= null)
		{
			map.put(temp1.val, temp1.val);
			temp1= temp1.next;
		}
		
		//iterating second list
		
		while(temp2!= null)
		{
			if(map.containsKey(temp2.val) ==true)
			{
				linkList=temp2;
				break;
			}
			temp2= temp2.next;
		}
		
		
		
		
		return linkList;
	}
	
	public Node addNode(Node head,int value)
	{
		Node newNode = new Node(value);
		Node temp=head;
			
		if (temp!=null)
    	{
    		//assiging location of already pointed head node  in to new node 
    		newNode.next=temp;
    		//Moving head to this node
    		//head=newNode;
    		
    	}
    	
		head=newNode;
    	
    		
    		return head;

	}
	
	 private static final Scanner scanner = new Scanner(System.in);
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Input example
		 * 3
		 * 1 2 3
		 * 5 
		 * 7 8 9 3 10
		 * 
		 * result : 3
		 */
		
		IntersectingNode llist = new IntersectingNode();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i <llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            //llist.insertNode(llistItem);
            
            Node llist_head = llist.addNode(llist.head, llistItem);
            llist.head = llist_head;
            
        }
		
        IntersectingNode llist2 = new IntersectingNode();

        int llistCount2 = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount2; i++) {
            int llistItem2 = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            //llist.insertNode(llistItem);
            
            Node llist_head2 = llist.addNode(llist2.head, llistItem2);
            llist2.head = llist_head2;
            
        }
        
        IntersectingNode llist3 = new IntersectingNode();
        
        Node intersectNode = llist3.findIntersectingNode(llist.head, llist2.head);
        
        System.out.println("Value : " + intersectNode.val);
	}

}

