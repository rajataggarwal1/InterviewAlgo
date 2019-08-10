package com.leetcode.tree;
/*
 * 112. Path Sum
Easy

https://leetcode.com/problems/path-sum/

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * 
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class PathSum112 {
	public boolean hasPathSum(TreeNode root, int sum) {
	     // Recursion- Passing sum-root.value to check left and right subtree
	      // dividing into sub smaller problem, two status variable to check which side have full sum
	        // finnaly retun true/false based on flag value 
	        
	        
	        if(root==null )
	        {
	            return false;
	        }
	        boolean leftstatus=false;
	        boolean rightstatus=false;
	      
	        
	        if(root.left!=null)
	        {
	            leftstatus=hasPathSum(root.left, sum-root.val);            
	        }
	        if(root.right !=null)
	        {
	           rightstatus= hasPathSum(root.right, sum-root.val);             
	        }        
	         
	        if(root.left==null && root.right==null && ((sum-root.val)==0))
	        {             
	            return true;           
	        }
	        // If either side has full sum then return true, else false
	        if(leftstatus == true || rightstatus ==true)
	            return true;
	        else
	            return false;
	       
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSum112 m=new PathSum112();
		// creating tree we have to use other class. here just implemented code for calculating depth. It will not run here
		TreeNode root=new TreeNode(10);
		System.out.println("Sum Exist " +m.hasPathSum(root, 22));

	}

}
