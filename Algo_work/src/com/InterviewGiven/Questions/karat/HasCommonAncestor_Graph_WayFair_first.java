package com.InterviewGiven.Questions.karat;
/*
 * / Suppose we have some input data describing a graph of relationships between parents and 
children over multiple generations. The data is formatted as a list of (parent, child) pairs, 
where each individual is assigned a unique integer identifier.

// For example, in this diagram, 6 and 8 have a common ancestor of 4.

//          14  13
//          |   |
// 1   2    4   12
//  \ /   / | \ /
//   3   5  8  9
//    \ / \     \
//     6   7     11

// parentChildPairs1 = [
//     (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
//     (4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)
// ]

// Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

// Sample input and output:

// hasCommonAncestor(parentChildPairs1, 3, 8) => false
// hasCommonAncestor(parentChildPairs1, 5, 8) => true
// hasCommonAncestor(parentChildPairs1, 6, 8) => true
// hasCommonAncestor(parentChildPairs1, 6, 9) => true
// hasCommonAncestor(parentChildPairs1, 1, 3) => false
// hasCommonAncestor(parentChildPairs1, 7, 11) => true
// hasCommonAncestor(parentChildPairs1, 6, 5) => true
// hasCommonAncestor(parentChildPairs1, 5, 6) => true

// ----------------
// Additional example: In this diagram, 4 and 12 have a common ancestor of 11.

//         11
//        /  \
//       10   12
//      /  \
// 1   2    5
//  \ /    / \
//   3    6   7
//    \        \
//     4        8

// parentChildPairs2 = [
//     (11, 10), (11, 12), (10, 2), (10, 5), (1, 3),
//     (2, 3), (3, 4), (5, 6), (5, 7), (7, 8),
// ]

// hasCommonAncestor(parentChildPairs2, 4, 12) => true
// hasCommonAncestor(parentChildPairs2, 1, 6) => false
// hasCommonAncestor(parentChildPairs2, 1, 12) => false

// n: number of pairs in the input

My Approach
/*map :
key  value
1    3
2    3

value exist in map
14 -> 4
  4 -> 5 , 8 ,9
  5 -> 6 ,7
  
  
  input -> 6, 8
  
  4, 5
  14, 4
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HasCommonAncestor_Graph_WayFair_first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] parentChildPairs1 = new int[][] {
	        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
	        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}
	    };

	    int[][] parentChildPairs2 = new int[][] {
	        {11, 10}, {11, 12}, {10, 2}, {10, 5}, {1, 3},
	        {2, 3}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
	    };
	    
	    HasCommonAncestor_Graph_WayFair_first s=new HasCommonAncestor_Graph_WayFair_first();
	    s.hasCommonAncestor(parentChildPairs1, 3, 8);
	    
	    
	}
	
	
	
	public boolean hasCommonAncestor(int [][] parentChildPairs2, int child1, int child2)
	{
	  
	  Map<Integer, List<Integer>> map=new HashMap<Integer, List<Integer>>();
	  
	  // preprocessing
	  for(int i=0; i<parentChildPairs2.length; i++ )
	  {
	    
	      
	      if(map.containsKey(parentChildPairs2[i][0]))
	      {
	        List<Integer> val= map.get(parentChildPairs2[i][0]);
	        
	        val.add( parentChildPairs2[i][1]);
	        map.put(parentChildPairs2[i][0], val);    
	        
	        
	      }
	    else
	    {
	      List<Integer> val= new ArrayList<Integer>();
	      
	        val.add(parentChildPairs2[i][1]);
	        
	        map.put(parentChildPairs2[i][0], val);    
	      
	    }  
	    
	  }
	  
	  // checking whether same parent or not
	 boolean result= hasCommonAncestorHelper(map, child1,  child2);
	  
	  
	  
	  
	  return result;
	  
	}

	public boolean hasCommonAncestorHelper(Map<Integer,List<Integer>> map,int child1, int child2)
	{
	  boolean isComParaent=false;
	  
	  int tempParent=-1;
	  
	  for(Map.Entry<Integer,List<Integer>> element=(Entry<Integer, List<Integer>>) map.entrySet())
	  {
	    element.getKey();
	     List<Integer> val=element.getValue();
	    
	    if(val.size()>1)
	    {
	      
	      
	      
	    }
	    
	    
	    
	    
	  }
	  
	  
	  
	}

}
