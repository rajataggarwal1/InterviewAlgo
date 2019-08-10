package com.leetcode.tree;

/*
 * 111. Minimum Depth of Binary Tree
Easy

805

443

Favorite

Share
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
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


public class MinimumDepthofBinaryTree111 {
	
	public int minDepth(TreeNode root) {
	      /*  Instead of regular depth of a tree calculating method, we want to find the minimum depth on a non-null path.
	Non-null is important as the solution expects that if there are no nodes in a path, then it would not be considered in min-depth path solution.
	if any of the left-depth(ld) or right-depth(rd) is 0, we will return the other depth + 1
	else we will return min(ld,rd) + 1*/
	        
	        // getting left tree depth and right tree depth.
	        // returning min(leftdepth, right depth)+1
	        // other condition for checking if we have only left long subtree or right long subtree.
	        // check if left 0 then return right depth +1 and viceversa
	        
	        if(root==null)
	        {
	            return 0;
	        }
	        
	         int lDepth=0;
	        int rDepth=0;
	        
	        if(root.left !=null)
	        {
	           lDepth= minDepth(root.left);
	            
	        }
	        
	        if(root.right !=null)
	        {
	            rDepth= minDepth(root.right);
	        }
	       // no left node all right node 
	        if(lDepth == 0 )
	        {
	            return rDepth+1;
	        }
	        // no right node all left node
	        if(rDepth == 0 )
	        {
	            return lDepth+1;
	        }
	        return Math.min(lDepth, rDepth)+1;
	       
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumDepthofBinaryTree111 m=new MinimumDepthofBinaryTree111();
		// creating tree we have to use other class. here just implemented code for calculating depth. It will not run here
		TreeNode root=new TreeNode(10);
		System.out.println("depth is" +m.minDepth(root));
	}

}
