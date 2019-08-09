package com.leetcode.tree;
/*
 * 104. Maximum Depth of Binary Tree
Easy

https://leetcode.com/problems/maximum-depth-of-binary-tree/

Favorite

Share
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 * 
 * 
 * 
 */


// Definition for a binary tree node.
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
 
public class MaximumDepthofBinaryTree104 {
public int maxDepth(TreeNode root) {
        
        if(root==null)
            return 0;
        
        return maxDepthHelper(root, 1);
      
    }
   // Helper to calculate depth
    public int maxDepthHelper(TreeNode root, int depth)
    {
        if(root==null)
            return depth;
        
        int ldepth=depth;
        int rdepth=depth;
        if(root.left !=null)
        {
          
           ldepth=maxDepthHelper(root.left, depth+1);
          
        }
        if(root.right !=null)
        {
           
            rdepth=maxDepthHelper(root.right, depth+1);
            
        }
        // checking maximum depth from left and right subtree and returning the max depth
        return Math.max(ldepth,rdepth);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumDepthofBinaryTree104 m=new MaximumDepthofBinaryTree104();
		// creating tree we have to use other class. here just implemented code for calculating depth. It will not run here
		TreeNode root=new TreeNode(10);
		System.out.println("depth is" +m.maxDepth(root));
	}

}
