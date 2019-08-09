import java.io.IOException;
import java.util.*;





public class BackupOfLRUCache {
	
	
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
		
	}
	
	
	
	int capacity;
	LRUNode head;
	LRUNode tail;
	HashMap<Integer, LRUNode> map;
	
		
		
	
public BackupOfLRUCache(int capacity) {
        this.capacity=capacity;
        map= new HashMap<Integer, LRUNode>();
        head=null;
    	tail=null;
        
    }
    
    public int get(int key) {
    	
    		
    	
    	if (map.containsKey(key))
    	{
    		LRUNode middle= (LRUNode) map.get(key);
    		//LRUNode newNode= new LRUNode(key,middle.value);
        	//newNode.next=null;
    		
    		
    		
    		if (head.key==middle.key)
    		{
    			head=middle.next;
    			tail.prev.next=middle;
    			middle.prev=tail.prev;
    			tail=middle;    			
    			middle.next=null;
    			
    		}
    		else if (!(tail.key==middle.key))
    		{
    			LRUNode temp=middle;
    			middle.next.prev=middle.prev;
    			middle.prev.next=middle.next;
    			
    			tail.prev.next=temp;
    			temp.prev=tail.prev;
    			tail=temp;    			
    			temp.next=null;
    			
    			
    		}
    		
    		
    		
    		return middle.key;	
    	}
    		else
    			return -1;
    	
    }
    
    public void put(int key, int value) {
    	
    	
    	//newNode.next=null;
    	if (!map.containsKey(key))
    	{
    		//LRUNode middle= (LRUNode) map.get(key);
    		//middle.prev.next= middle.next;
    		
    		LRUNode newNode= new LRUNode(key,value);
    	
    		if(capacity==0)
    		{
    			LRUNode temp=head;
    			head=head.next;
    			map.remove(temp.key);
    			capacity++;
    					
    		}
    		if(head==null && tail==null)
    		{
    			
    			head=newNode;
    			head.next=newNode;
    			
    					
    		}
    		else
    		{
    			tail.next=newNode;
    			newNode.prev=tail;
    			newNode.next=null;
    					
    		}
    		tail=newNode;
    		map.put(key, newNode);
    		capacity--;
    	}
    	        
    }
    
    public static void main(String[] args) throws IOException {
    
    	BackupOfLRUCache cache= new BackupOfLRUCache(2);
    	
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
