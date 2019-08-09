package com.leetcode;

import com.leetcode.ListNode;
/**
 * https://leetcode.com/problems/linked-list-cycle/
 * 141. Linked List Cycle
Easy

1398

130

Favorite

Share
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.


 

Follow up:

Can you solve it using O(1) (i.e. constant) memory?
 * 
 * 
 * @author rajat
 *
 */
public class LinkedListCycle141 {
	public boolean hasCycle(ListNode head) {
        
        if(head==null || head.next==null)
            return false;
        
        ListNode slowHead=head;
        ListNode fastHead=head.next; // setting fastpointer one point ahead of slow pointer
        
        // If loop then at one point both will became equal
        while(slowHead != fastHead )
        {
            //System.out.println("slowHead.val " + slowHead.val + " fastHead.val " +fastHead.val);
            // If no loop then below condition will became true
            if(fastHead==null || fastHead.next == null)
            {
                return false;
            }
            else
            {
                // move fast pointer two time
                fastHead=fastHead.next.next;
                slowHead=slowHead.next;
            }
        }
        
        return true;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// need to implement linklist implement so that list can be inserted for further operation
	}

}
