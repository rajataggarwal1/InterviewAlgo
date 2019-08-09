package com.leetcode;
/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 82. Remove Duplicates from Sorted List II
Medium

727

68

Favorite

Share
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
 * 
 * 
 * 
 */
public class RemoveDuplicatesFromSortedListII_82 {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	
	public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null)
          return head;
      
      ListNode  temp=head;
      ListNode dummyNode= new ListNode(-1);
      
      dummyNode.next=temp;
      temp=dummyNode;
      
      ListNode  dupHead=temp;
      ListNode  counterHead=head;

      int count=0;

      while( counterHead!=null)
      {
          
          if(dupHead.next.val == counterHead.val)
          {
              // System.out.println("counterHead.val " + counterHead.val + " dupHead.next.val " +dupHead.next.val );
              count++;
               counterHead=counterHead.next;
              
              continue;
          }
          
          if(count>1)
          {
              dupHead.next=counterHead;
             
          } 
          else
          {
              dupHead=dupHead.next;
          }
           count=0;
          
      }

      
      
   // Check if counter is more then 1 it means all last nodes are duplicate which is not deleted in loop and require to delete outside loop 
      if(count>1)
      {
          dupHead.next=counterHead;
       
      } 
   // updating head with Tem which is still pointing to -1(dummy node)
      // Then update head to actual value
      head=temp;
      head=head.next;
      
      return head;
      
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesFromSortedListII_82 d=new RemoveDuplicatesFromSortedListII_82();
		
		// Need to witre insert node function to run this program
	}

}
