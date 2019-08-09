package com.leetcode;
/*
 * 23. Merge k Sorted Lists
Hard

2151

136

Favorite

Share
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 * 
 */
public class MergeKSortedLists23 {
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode firstList;
        ListNode secondList;
        ListNode mergedList;
        
        if(lists.length==1)
            return lists[0];
        
        firstList=lists[0];
        mergedList=lists[0];
            
        ListNode returnList=mergedList;
        for(int i=1; i< lists.length; i++)
        {
            
            secondList=lists[i];
            ListNode interList=mergedList;
            
            while(firstList!=null && secondList!=null)
            {
                if(firstList.val<secondList.val)
                {
                    mergedList.next=firstList;
                    mergedList=mergedList.next;
                    firstList=firstList.next;
                }
                else if(secondList.val<firstList.val)
                {
                    mergedList.next=secondList;
                    mergedList=mergedList.next;
                    secondList=secondList.next;
                    
                    
                }
                else
                {
                     mergedList.next=secondList;
                    mergedList=mergedList.next;                    
                    secondList=secondList.next;
                    
                    mergedList.next=firstList;
                    mergedList=mergedList.next;
                    firstList=firstList.next;
                }
                
            }
            while(firstList!=null)
            {
                mergedList.next=firstList;
                    mergedList=mergedList.next;
                    firstList=firstList.next;
            }
            while(secondList!=null)
            {
                mergedList.next=secondList;
                mergedList=mergedList.next;                    
                secondList=secondList.next;
            }
            
            firstList=interList;
        }
        
        
        return returnList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public class ListNode {
		     int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		       }

}
