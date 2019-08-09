package com.hackersRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 *You are given the pointer to the head node of a linked list and an integer to add to the list. Create a new node with the given integer. Insert this node at the tail of the linked list and return the head node of the linked list formed after inserting this new node. The given head pointer may be null, meaning that the initial list is empty.

Input Format

You have to complete the SinglyLinkedListNode insertAtTail(SinglyLinkedListNode head, int data) method. It takes two arguments: the head of the linked list and the integer to insert at tail. You should not read any input from the stdin/console.

The input is handled by code editor and is as follows: 
The first line contains an integer , denoting the elements of the linked list. 
The next  lines contain an integer each, denoting the element that needs to be inserted at tail.

Constraints

Output Format

Insert the new node at the tail and just return the head of the updated linked list. Do not print anything to stdout/console.

The output is handled by code in the editor and is as follows: 
Print the elements of the linked list from head to tail, each in a new line.

Sample Input

5
141
302
164
530
474
Sample Output

141
302
164
530
474
Explanation

First the linked list is NULL. After inserting 141, the list is 141 -> NULL. 
After inserting 302, the list is 141 -> 302 -> NULL. 
After inserting 164, the list is 141 -> 302 -> 164 -> NULL. 
After inserting 530, the list is 141 -> 302 -> 164 -> 530 -> NULL. After inserting 474, the list is 141 -> 302 -> 164 -> 530 -> 474 -> NULL, which is the final list.
 */


public class SinglyLinkedListInsertLast {

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

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
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
    
    // Created function to insert at last and returing head
    //It will take user input and first parameter id no of node to be created. one in each line.
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode newNode= new SinglyLinkedListNode(data);
       
        // checking if it is first node meand head is null
        if (head == null) {
            head = newNode;
        } else {
        	//Iterating till last and breaking before last node so that new node can be added.
        	 while(temp != null)
             {
                 if(temp.next != null)
                 {
                	 temp=temp.next;
                 }
                 else
                 {
                	 temp.next=newNode;
                     break;
                 }
             }
        }

       
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
            
            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);
            llist.head = llist_head;
            
        }

        printLinkedList(llist.head);

        scanner.close();
    }
}