package com.cache;

public class Node {
	public int key;
	public int value;
	
	Node next;
	Node prev;
	public Node(int key, int value)
	{
		this.key=key;
		this.value=value;
		this.next=null;
		this.prev=null;
	}
	
	public Node()
	{
		this.next=null;
		this.prev=null;
	}
}
