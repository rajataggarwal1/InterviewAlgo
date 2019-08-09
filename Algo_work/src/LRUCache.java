import java.io.IOException;
import java.util.*;





public class LRUCache {
	
	
	class LRUNode{
		
		LRUNode next;
		LRUNode prev;
		int key;
		int value;
		public LRUNode(int key, int value)
		{
			this.key=key;
			this.value= value;
		}
		public LRUNode()
		{}
	}
	
	
	
	int capacity;
	LRUNode head;
	LRUNode tail;
	HashMap<Integer, LRUNode> map;
	
		
		
	
public LRUCache(int capacity) {
        this.capacity=capacity;
        map= new HashMap<Integer, LRUNode>();
        head=null;
        tail=null;
        
    }
    
public void moveToFirst(LRUNode node)
{
	/*LRUNode temp=head;
	
	node.next=head;
	node.prev=null;
	temp.prev=node;
	head=node;*/
	
	if (this.tail == null) {
        this.tail = node;
    } else {        
        this.head.prev = node;
        node.next=head;
    }
	 this.head = node;
    
	
}

public void removeNode(LRUNode node)
{
	//LRUNode temp=node;
	if((node.next != null) && (node.prev!=null))
	{	
		node.prev.next = node.next;
		node.next.prev=node.prev;
	}
	else 
	{
		tail.prev.next=null;		
		tail.prev=tail;
	}
}

public void removeFromEnd()
{
	
	tail=tail.prev;
	tail.next=null;
}

    public int get(int key) {
    	
    	LRUNode getNode= (LRUNode) map.get(key);
    		
    	
    	if (getNode!=null)
    	{
    		removeNode(getNode);
    		moveToFirst(getNode);
    		
    		return getNode.key;
    		
    	}
    	else
    	{
    		return -1;
    		
    	}
    	
    }
    
    public void put(int key, int value) {
    	
    	LRUNode getNode= (LRUNode) map.get(key);
    	
    	if(getNode==null)
    	{
    		LRUNode newNode=new LRUNode(key,value);
    		
    		if(this.head==null)
    		{
    			
    			this.head=newNode;
    			this.tail=newNode;
    			
    			
    		
    			map.put(key, newNode);
    			capacity--;
    		}
    		else
    		{
    			
				//head=newNode;
				
				
	    		if(capacity > 0)	    			
	    		{
	    			LRUNode temp;
	    			temp=head;
	    			
		    		newNode.next=temp;
					newNode.prev=null;
					temp.prev=newNode;
					
	    			map.put(key, newNode);
	    			capacity--;
	    		}
	    		else
	    		{//Capacity now is zero
	    			map.put(key, newNode);
	    			map.remove(tail.key);
	    			removeFromEnd();
	    			
	    		}
    		}
    	}
    	
    	
    	        
    }
    
    public static void main(String[] args) throws IOException {
    
    	LRUCache cache= new LRUCache(2);
    	
    	int returnVal=-1;
    	
    	cache.put(1, 1);
    	cache.put(2, 2);
    	returnVal=cache.get(1);       // returns 1
    	
    	System.out.println("returnVal 1 -> "+returnVal);
    	
    	
    	cache.put(3, 3);    // evicts key 2
    	returnVal=cache.get(2);       // returns -1 (not found)
    	
    	System.out.println("returnVal 2 (returns -1 (not found))-> "+returnVal);
    	
    	cache.put(4, 4);    // evicts key 1
    	returnVal=cache.get(1);       // returns -1 (not found)
    	System.out.println("returnVal 1 (returns -1 (not found))-> "+returnVal);
    	
    	returnVal=cache.get(3);       // returns 3
    	
    	System.out.println("returnVal 3 (returns 3)-> "+returnVal);
    	
    	returnVal=cache.get(4);       // returns 4
    	
    	System.out.println("returnVal 4 (returns 4)-> "+returnVal);
    	
    }
    
    
}
