import java.util.*;


public class LinkListOps {

	public void deleteNode(ListNode node) {
        
       
        	
        	ListNode p=new ListNode(0);
        p.next= node;
        	
        
        	while (p !=null && p.next!=null)
        	{
        		
        		if(p.next.val==node.val)
        		{
        			p.next=p.next.next;
        		}
        		p=p.next;
        		
        	}
        	
        
        	public static void main(String args[])
        	{
        		LinkListOps llo=new LinkListOps();
        		
        		llo.deleteNode(node);
        	}
}

/**
 * Definition for singly-linked list.
 */
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 

}
