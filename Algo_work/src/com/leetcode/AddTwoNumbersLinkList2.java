package com.leetcode;
/*
 * 2. Add Two Numbers
Medium

4719

1197

Favorite

Share
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 * 
 * 
 * 
 */
public class AddTwoNumbersLinkList2 {
	//Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	  
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Temp=l1;
        ListNode l2Temp=l2;
        
        ListNode returnNode=null;
       
        int sum=0;
        int carry=0;
       
        //Iterating both list to get sum
        
        while(l1Temp !=null && l2Temp !=null)
        {
            
            sum=carry + l1Temp.val + l2Temp.val;
            carry=sum/10;
            //calling function to calculate node value and creating it
            returnNode=calculateNodeValue( returnNode,  sum);
            sum=0;

            l1Temp=l1Temp.next;
            l2Temp=l2Temp.next;
        }
        
        // Iterating first list if send is small and element left in first list
        while(l1Temp !=null)
        {
            sum=carry + l1Temp.val ;
            carry=sum/10;
            returnNode=calculateNodeValue( returnNode,  sum);
            sum=0;
            l1Temp=l1Temp.next;
            
        }
        
         // Iterating second list if first is small and element left in second list
        while(l2Temp !=null)
        {
            sum=carry + l2Temp.val ;
            carry=sum/10;
            returnNode=calculateNodeValue( returnNode,  sum);
            sum=0;
            l2Temp=l2Temp.next;
             
        }
        
        // Adding node in final list if carry is overflowing like last number is 8+8 =16  We have create node for 1
        if(carry==1)
            returnNode=createNode(returnNode, 1);
        
        
        return returnNode;
    }
    
    // Calculating node value which is final sum and create node accordingly
     public ListNode calculateNodeValue(ListNode returnNode, int sum)
     {
                
        if(sum>9)
        {
        //carry=1;
            returnNode=createNode(returnNode, sum%10);
        }
        else
        {
        // carry=0;
            returnNode=createNode(returnNode, sum);
        }
         return returnNode;
     }
    
    // Creating node for final sum
    public ListNode createNode(ListNode returnNode, int val)
    {
        ListNode newNode=new ListNode(val);
        newNode.next=null;
        
        if(returnNode == null)
        {
             returnNode=newNode;
        }
        else
        {
            //System.out.println("in else  " + val + "--------------");
            //Assining head node to current pointer so that we do not lose head
            ListNode temp=returnNode;
            while( temp.next != null)
            {

                temp=temp.next;
                
            }
            temp.next=newNode;
            
        }
        return returnNode;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * Test case
 * 
 First 
 [1]
[9,9]

second :

[1,1]
[9,9]
 * 
 */
	}

}
