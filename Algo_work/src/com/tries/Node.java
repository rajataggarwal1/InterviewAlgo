package com.tries;

import java.util.HashMap;

public class Node {
	
	public Node child;
	
	public char ch;
	
	public boolean isWorld;
	
	public HashMap map = new HashMap();
	
	public Node(char ch, boolean isWorld)
	{
		this.ch=ch;
		this.isWorld=isWorld;
		this.child=null;
		
	}
	
	public Node()
	{
		
	}
	
	
	

}
