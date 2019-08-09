package com.cache;



import java.util.HashMap;

public class LRUCache {

	public int key;
	public int value;
	
	Node head;
	Node tail;
	public int capicity;
	
	public HashMap map;
	
	public LRUCache(int cap)
	{
		this.capicity=cap;
		map= new HashMap(cap);
		
		head=null;
		tail=null;
	}
	
	
	
	public void addFirst(int key, int value)
	{
		Node newNode= new Node(key,value);
		
		if(head==null)
		{
			tail=newNode;
			newNode.next=head;
			head=newNode;
		}
		else
		{
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
			
		}
	}
	
	
	public Node  removeLast()                              
	{
		Node temp=tail;
		
		if(tail.prev==null)
		{
			head=null;
			tail=null;
			//capicity++;
		}
			
		
		if(tail!=null)
		{
			tail.prev.next=null;
			tail=tail.prev;
		}
		return temp;
	}
	
	public int getCacheValue(int key)
	{
		if(map.containsKey(key))
		{
			Node nodeToMove=removeLast();
			addFirst(nodeToMove.key,nodeToMove.value);
			return nodeToMove.value;
			
		}
		else
			return -1;
	}
	
	public void addCache(int key, int value)
	{
		Node newNode;
		
		if(map.containsKey(key))
			{
				Node nodeToMove=removeLast();
				//addFirst(nodeToMove.key,nodeToMove.value);
				addFirst(key,value);
			}
		else
		{
			if	(capicity==0)
			//if	(map.size() == capicity)
			{
				Node nodeToRemove=removeLast();
				map.remove(nodeToRemove.key);
			}
			addFirst(key,value);
			map.put(key, value);
			if(capicity>0)
				capicity--;
		}
			
		
	 
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			
		LRUCache cache= new LRUCache(2);
    	
		System.out.println(cache.getCacheValue(2));
    	 	
    	cache.addCache(2, 6);
    	System.out.println(cache.getCacheValue(1));
    	cache.addCache(1, 5);
    	cache.addCache(1, 2);
    	System.out.println(cache.getCacheValue(1));
    	System.out.println(cache.getCacheValue(2));
    	int returnVal=cache.getCacheValue(2);       // returns 1
    	
    	System.out.println(returnVal);
    	
    	cache.addCache(1, 1);
    	
    	cache.addCache(4, 1);    // evicts key 2
    	returnVal=cache.getCacheValue(2);       // returns -1 (not found)
    	
    	System.out.println(returnVal);
    	
    //	returnVal=cache.getCacheValue(3);
  //	System.out.println(returnVal);
    			
    /*			
    	cache.addCache(4, 4);    // evicts key 1
    	returnVal=cache.getCacheValue(1);       // returns -1 (not found)
    	System.out.println("returnVal 1 (returns -1 (not found))-> "+returnVal);
    	
    	returnVal=cache.getCacheValue(3);       // returns 3
    	
    	System.out.println("returnVal 3 (returns 3)-> "+returnVal);
    	
    	returnVal=cache.getCacheValue(4);       // returns 4
    	
    	System.out.println("returnVal 4 (returns 4)-> "+returnVal);*/
		
	}

}
