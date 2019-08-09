package com.hackersRank;
/*
 * Function Description

Complete the getHeight or height function in the editor. It must return the height of a binary tree as an integer.

getHeight or height has the following parameter(s):

root: a reference to the root of a binary tree.
Note -The Height of binary tree with single node is taken as zero.

Input Format

The first line contains an integer , the number of nodes in the tree. 
Next line contains  space separated integer where th integer denotes node[i].data.

Note: Node values are inserted into a binary search tree before a reference to the tree's root node is passed to your function. In a binary search tree, all nodes on the left branch of a node are less than the node value. All values on the right branch are greater than the node value.

Constraints

 

Output Format

Your function should return a single integer denoting the height of the binary tree.
 * 
 * 
 */

import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class HeightOfBinaryTree {

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
	
	public static int height(Node root) {
      	// Write your code here.
		if(root==null)
		{
			return -1;
				
		}
		else
		{
			return 1+ Math.max(height(root.left), height(root.right));
		}
		
		
    }
	
	
	private static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
		

	}

}
