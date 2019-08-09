package com.leetcode;

import com.leetcode.ListNode;
/**
 *

Follow up:

Can you solve it using O(1) (i.e. constant) memory?
 * 
 * 
 * @author rajat
 *
 */
public class RotateList61 {
	public ListNode rotateRight(ListNode head, int k) {
        
        int listSize=0;
        ListNode temp=head;
		while (temp!=null)
		{
			listSize++;
			temp=temp.next;
		}
		
		int noOfRotate=0;
		
		if(listSize==k)
			return head;
		if(k > listSize)
		{
			noOfRotate=k-listSize;
		}
		else
		{
			noOfRotate=k;
		}
		
		temp=head;
		int tempcount=0;
		ListNode halfNode=null;
		while(temp!=null && temp.next!=null)
		{
			if(tempcount==(listSize-noOfRotate))
			{
				halfNode=temp;
				temp.next=null;
				break;
				
			}
			tempcount++;
			temp=temp.next;
		}
		
		temp=head;
        temp.next=halfNode;
        
        while(halfNode.next!=null)
        {
        	halfNode=halfNode.next;
        }
      
        halfNode.next=head;
        
        return head;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// need to implement linklist implement so that list can be inserted for further operation
	}

}
