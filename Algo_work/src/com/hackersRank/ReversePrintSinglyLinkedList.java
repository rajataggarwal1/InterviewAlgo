package com.hackersRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 *You’re given the pointer to the head node of a linked list and an integer to add to the list. Create a new node with the given integer, insert this node at the head of the linked list and return the new head node. The head pointer given may be null meaning that the initial list is empty.

Input Format

You have to complete the SinglyLinkedListNode Insert(SinglyLinkedListNode head, int data) method which takes two arguments - the head of the linked list and the integer to insert. You should NOT read any input from stdin/console.

The input is handled by code in the editor and is as follows:

The first line contains an integer , denoting the number of elements to be inserted at the head of the list. 
The next  lines contain an integer each, denoting the element to be inserted.

Constraints

Output Format

Insert the new node at the head and return the head of the updated linked list. Do NOT print anything to stdout/console.

The output is handled by the code in the editor and it is as follows:

Print the elements of linked list from head to tail, each in a new line.

Sample Input

5
383
484
392
975
321
Sample Output

321
975
392
484
383
Explanation

Intially the list in NULL. After inserting 383, the list is 383 -> NULL. 
After inserting 484, the list is 484 -> 383 -> NULL. 
After inserting 392, the list is 392 -> 484 -> 383 -> NULL. 
After inserting 975, the list is 975 -> 392 -> 484 -> 383 -> NULL. 
After inserting 321, the list is 321 -> 975 -> 392 -> 484 -> 383 -> NULL.
 */


public class ReversePrintSinglyLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedListClass {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedListClass() {
            this.head = null;
            this.tail = null;
        }

    }
    // Complete the printLinkedList function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static void printLinkedList(SinglyLinkedListNode head) {

    	SinglyLinkedListNode temp=head;
    	
    	while(temp!=null)
    	{
    		System.out.print(temp.data + " -> ");
    		temp=temp.next;
    	}
    }
    
    // Created function to insert at fist and moving head and returing head
    //It will take user input and first parameter id no of node to be created. one in each line.
   
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {

    	SinglyLinkedListNode newNode=new SinglyLinkedListNode(data);
    	//Assigning head into temp so that we should not loose the original location 
    	SinglyLinkedListNode temp=head;
    	
    	
    	if (temp!=null)
    	{
    		//assiging location of already pointed head node  in to new node 
    		newNode.next=temp;
    		//Moving head to this node
    		//head=newNode;
    		
    	}
    	/*else
    	{*/
    		head=newNode;
    	//}
    	
	
    	
    	
    	return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	SinglyLinkedListClass llist = new SinglyLinkedListClass();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            //llist.insertNode(llistItem);
            
            SinglyLinkedListNode llist_head = insertNodeAtHead(llist.head, llistItem);
            llist.head = llist_head;
            
        }

        printLinkedList(llist.head);

        scanner.close();
    }
}