package com.treeExample;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import com.treeExample.*;

public class TreeOperation {

	public BinaryTreeNode root;
	public TreeOperation()
	{
		root=null;
	}

	
	public BinaryTreeNode insertElementBST(BinaryTreeNode root,int val)
	{
		
		
		if(root==null)
		{
			BinaryTreeNode bsNode=new BinaryTreeNode(val);
			return bsNode;
		}
		else
		{
			if(root.value < val)
			{
				root.right= insertElementBST(root.right,val);
			}
			else
			{
				root.left= insertElementBST(root.left,val);
			}
			
			return root;
		}
	}
	
	
	public static void preOrderTraversal(BinaryTreeNode root)
	{
		if(root!=null)
		{
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
			
			System.out.print(root.value + " - ");
		}
	}
	
	public static void postOrderTraversal(BinaryTreeNode root)
	{
		if(root!=null)
		{
			System.out.print(root.value + " - ");
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			
			
		}
	}
	
	public static void inOrderTraversal(BinaryTreeNode root)
	{
		if(root!=null)
		{
			
			inOrderTraversal(root.left);
			System.out.print(root.value + " - ");
			inOrderTraversal(root.right);
			
			
		}
	}
	
	// Printing tree column asked by Facebook in interview
	public  void printTreeColumn(BinaryTreeNode root)
	{
		//linkedHashmap maintain the insertion order but it is not sorted. Either use SortedMap or TreeMap
		//LinkedHashMap<Integer,ArrayList<Integer>> map = new LinkedHashMap<Integer,ArrayList<Integer>>();
		
		TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();	
				
		if(root==null)
		{
			
			System.out.println("Root is null. Nothing to print");
		}
		else if(root.left==null && root.right==null)
		{
			ArrayList<Integer> treeColmnList=new ArrayList<Integer>();
			treeColmnList.add(root.value);
			map.put(0,treeColmnList);
		}
		else
		{
			//calling helper function to calculate column
			map=mapTreeWithColumn(0,map,root);
			
			// Printing values  from Map in column form
			System.out.println(map);
			
			System.out.println(map.firstEntry());
		
			
			// Get first entry from tree
			int colStartVal=map.firstEntry().getKey();
			
			
			ArrayList<Integer> lst=new ArrayList();
			for(int i=0; i< map.size();i++)
			{
				// Dynamically adding all the vale in arraylist.
				lst.addAll(map.get(colStartVal++));
	
			}
			
			System.out.println("Column format Print of Tree " + lst);
		
		}
	}
	
	// Mapping tree value with its column sso that it can print in column format. using treemap which sorted key while storing. 
	//and value is linkedlist with is keep expanding if similar column found
	// Formula used start with root which we marked as Zero
	// Left child column - root-1 , right child column = root+1
	// if root is 0 then left is -1 and right is 1 and it will continue for all of their child if root is -1 then left -2 and right 0
	public TreeMap mapTreeWithColumn(int column,TreeMap map,BinaryTreeNode root)
	{
		
		if(root==null)
			return map;
		
		
		if(map.containsKey(column))
		{
			ArrayList<Integer> treeColmnList=(ArrayList)map.get(column);
			treeColmnList.add(root.value);
			map.put(column,treeColmnList);
		}
		else
		{
			ArrayList<Integer> treeColmnList=new ArrayList<Integer>();
			treeColmnList.add(root.value);
			map.put(column,treeColmnList);
		}
		
		if(root!=null)
		{
			map = mapTreeWithColumn(column-1,map,root.left);
			map= mapTreeWithColumn(column+1,map, root.right);
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeOperation t=new TreeOperation();
		BinaryTreeNode root=null;
		root=t.insertElementBST(root,15);
		root=t.insertElementBST(root,20);
		root=t.insertElementBST(root,25);
		root=t.insertElementBST(root,22);
		
		root=t.insertElementBST(root,10);
		root=t.insertElementBST(root,5);
		root=t.insertElementBST(root,8);
		root=t.insertElementBST(root,9);
		root=t.insertElementBST(root,4);
		root=t.insertElementBST(root,6);
		root=t.insertElementBST(root,3);
		
		System.out.println("Pre order Traversal ");
		preOrderTraversal(root);
		System.out.println("\nPost Order Traversal");
		postOrderTraversal(root);
		System.out.println("\nIn Order traversal ");
		inOrderTraversal(root);
		
		t.printTreeColumn(root);
		
		
		
		
	}

}
