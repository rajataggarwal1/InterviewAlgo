package com.geeksforgeeks.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1
 * 
 * Given two BST, you need to print the elements of both BSTs in sorted form.

Input Format:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains three lines. The first line of each test case contain's an integer N and M denoting the size of the two BST's. Then In the next two line are space separated values of the two BST's.

Output Format:
For each testcase, in a new line, print the elements of both BSTs in sorted form.

Your Task:
This is a function problem, you don't have to take any input. Just complete the function merge() that nodes of both BSTs as parameters.

Constraints:
1 <= T <= 100
1 <= N,M <= 100

Example:
Input:
2
3 3
1 33 4 
6 7 1
2 2
1 6
9 2

Output:
1 1 4 6 7 33
1 2 6 9

Explanation:
Testcase1: The BSTs look like

BST1:
                1
                  \
                    4
                       \
                         33

BST2:
                     6
                    /   \
                   1    7
The sorted elements of above BSTs are 1 1 4 6 7 33
 * 
 */
/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
//Node is as follows:
class Node{
	int data;
	Node left, right;
	Node(int d){
		data=d;
		left=right=null;
	}
}


public class MergeTwoBST {

	public static void main(String[] args) 	
    {
    	// Building first Tree    	
    	int [] arr1= { 10, 15, 16, 19, 20, 100, 250};
    	int [] arr2= { 3, 5, 7, 9, 12, 30, 35, 50, 500};
    	
    	// Building first Tree    	
    	Node root1= createTreeUsingBinarySearchFromSortedArray(arr1,0, arr1.length);
    	// Building Second  Tree    	
    	Node root2= createTreeUsingBinarySearchFromSortedArray(arr2,0, arr2.length);
    	
    
    
       /* 1. Covert BSt to array using inorder
        2. merge two sorted array
        3. rebuild binary tree*/
            //add code here.
        
        //1. Covert BSt to array using inorder  
        ArrayList<Integer> lst1=new ArrayList<Integer>();
        ArrayList<Integer> lst2=new ArrayList<Integer>();
        inorder(root1, lst1);
        inorder(root2, lst2);
        
        System.out.println("----------------");
        System.out.println(lst1);
        System.out.println(lst2);
        
        //2. merge two sorted array
        ArrayList<Integer> mergeList=mergeSortedList(lst1,lst2);
        System.out.println(mergeList);
        
        /* Program only expecting to print the output no need to build teh tree again*/
        /*for(int i=0; i<mergeList.size();i++ )
        {            
            System.out.print(mergeList.get(i) + " ");
        
        }*/
        
        //3. rebuild binary tree using binarySearch
        Node node;
        node=bst( mergeList,0,mergeList.size()-1);
        // Print node
        printTree(node);
        
        
        /******************Creating binary serach tree using unsorted array*********************************/
        System.out.println("\n--Printing BST tree created using non sorted array--------------");
        int [] arr3= { 32, 1 , 5, 10, 15,9, 16, 19, 20, 100, 250, 22};
        Node bstTree=createBinaryTreeFromUnSortedArray(arr3);
        
        printTree(bstTree);
        
        /***********/
        
        MergeTwoBST tree=new MergeTwoBST();
        int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5}; 
        int n = parent.length; 
        Node node1 = tree.createTree(parent, n); 
        System.out.println("\n Inorder traversal of constructed tree "); 
        printTree(node1);
        
    }
    
    //1. Covert BSt to array using inorder
    public static void inorder(Node root, ArrayList<Integer> lst)
    {
        if(root==null)
            return;
            
            if(root.left!=null)
                inorder(root.left, lst);
                
            lst.add(root.data);
            
            if(root.right !=null)
                inorder(root.right,lst);
                
        return;
        
        
    }
    
    public static ArrayList<Integer> mergeSortedList(ArrayList<Integer> lst1, ArrayList<Integer> lst2)
    {
        if(lst1.size()==0)
            return lst2;
        if(lst2.size()==0)
            return lst1;   
        
        ArrayList<Integer> mergeList=new ArrayList<Integer>();
        
        int i=0;
        int j=0;
        
        while(i< lst1.size() && j< lst2.size())
        {
            if(lst1.get(i) <= lst2.get(j))
            {
                mergeList.add(lst1.get(i));
                i++;
            }
            else
            {
                mergeList.add(lst2.get(j));
                j++;
            }
            
        }
        
        while( j< lst2.size() )
        {
             mergeList.add(lst2.get(j));
             j++;
        }
        
        while(i< lst1.size())
        {
             mergeList.add(lst1.get(i));
             i++;
        }
        
        return mergeList;
    }
    
    // build tree using Binary search from Array
    public static Node createTreeUsingBinarySearchFromSortedArray(int[] arr, int i, int j)
    {
        if(i >= j)
            return null;
            
            int mid= (i+j)/2;
            Node newNode=new Node(arr[mid]);
         
            newNode.left=createTreeUsingBinarySearchFromSortedArray(arr,i, mid-1);
            newNode.right=createTreeUsingBinarySearchFromSortedArray(arr,mid+1, j);
        
        return newNode;
        
    }
    
 // build tree using Binary search from ArrayList
    public static Node bst(ArrayList<Integer> lst, int i, int j)
    {
        if(i > j)
            return null;
            
            int mid= (i+j)/2;
            Node newNode=new Node(lst.get(mid));
         
            newNode.left=bst(lst,i, mid-1);
            newNode.right=bst(lst,mid+1, j);
        
        return newNode;
        
    }
   
    // Creating binary search tree  from unsorted array
    private static Node createBinaryTreeFromUnSortedArray(int arr1[])
    {
    	
    	if(arr1.length ==0)
    		return null;
    	
    Node root=new Node(arr1[0]);
    	
    for(int i=1; i< arr1.length; i++)
    {    	
    	root= buildTree(arr1[i],root );
    	
    }
    	
    return root;  
    	
    }
    
    private static Node buildTree(int i, Node root)
    {
    	Node temp=root; 
    	Node newNode=new Node(i);
    	while(temp.left !=null || temp.right!=null)
    	{
    		if( temp.data <= i)
    		{
    			if(temp.left !=null)
    				temp=temp.left;
    			else
    			{
    				break;
    			}
    		}
    		else
    		{
    			if(temp.right !=null)
    				temp=temp.right;
    			else
    			{
    				break;
    			}
    		}
    	}	
    		
    		if(temp.data >= i)
    		{
    			temp.left=newNode;
    		}
    		else
    		{
    			temp.right=newNode;
    		}
    		
    		return root;
    	
    }

    private static void printTree(Node root)
    {
    	// print using inorder traversal
    
    	 if(root==null)
             return;
             
             if(root.left!=null)
            	 printTree(root.left);
                 
           System.out.print(root.data +" , ");
             
             if(root.right !=null)
            	 printTree(root.right);
                 
         return;
    }
    /**********Geeks for geeks code ********/
 // Creates a node with key as 'i'.  If i is root, then it changes 
    // root.  If parent of i is not created, then it creates parent first 
    Node root; 
     void createNode(int parent[], int i, Node created[])  
    { 
        // If this node is already created 
        if (created[i] != null) 
            return; 
   
        // Create a new node and set created[i] 
        created[i] = new Node(i); 
   
        // If 'i' is root, change root pointer and return 
        if (parent[i] == -1)  
        { 
            root = created[i]; 
            return; 
        } 
   
        // If parent is not created, then create parent first 
        if (created[parent[i]] == null) 
            createNode(parent, parent[i], created); 
   
        // Find parent pointer 
        Node p = created[parent[i]]; 
   
        // If this is first child of parent 
        if (p.left == null) 
            p.left = created[i]; 
        else // If second child 
           
            p.right = created[i]; 
    } 
   
    /* Creates tree from parent[0..n-1] and returns root of  
       the created tree */
    Node createTree(int parent[], int n)  
    {     
        // Create an array created[] to keep track 
        // of created nodes, initialize all entries 
        // as NULL 
        Node[] created = new Node[n]; 
        for (int i = 0; i < n; i++)  
            created[i] = null; 
   
        for (int i = 0; i < n; i++) 
            createNode(parent, i, created); 
   
        return root; 
    } 
   

}
