package com.Practice.Qtest;

/*
 * Reverse a link without Recursion: Time Limit 30 minutes, 200 points
 * a. Define your own link list class
 * 
 * 
 */
public class ReverseList {

	public static Node head=null;
	
	public ReverseList()
	{
		//this.head=new Node(-1);
		//this.head.next=null;
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseList rl=new ReverseList();
		Node hNode=new Node();
		
		 hNode=rl.insert(hNode, 1);
		hNode=rl.insert(hNode, 2);
		hNode=rl.insert(hNode, 3);
		hNode=rl.insert(hNode, 4);
		
		rl.printLinkedList(hNode);
		
		Node nhead=rl.reverseList(hNode);
		
		rl.printLinkedList(nhead);
	}
	
	
	
	
	public static Node reverseList(Node head)
	{
		
		Node temp=head;
		Node prev=null;
		
		
		while(temp!=null)
		{
			
			Node next=temp.next;
			temp.next=prev;
			prev=temp;
			temp=next;		
			
			
		}
		
		return head;
		
	}
	
	public static Node insert(Node head, int nodeData) {
		Node node = new Node(nodeData);
		node.next=null;
        if (head == null) {
            head = node;
        } else {
        	Node temp=head;
        	while(temp.next!=null)
        	{
        		temp=temp.next;
        	}
            temp.next = node;
        }
        return head;
       
    }
	
	
	public static void printLinkedList(Node head) {

    	Node temp=head;
    	
    	while(temp!=null)
    	{
    		System.out.print(temp.val + " -> ");
    		temp=temp.next;
    	}
    }
	
	/**
	 * Definition for singly-linked list.
	 */
	
	static class Node {
	    int val;
	    Node next;
	    Node()
	    {
	    	next=null;
	    }
	    Node(int x) { val = x; }
	}

}
 
