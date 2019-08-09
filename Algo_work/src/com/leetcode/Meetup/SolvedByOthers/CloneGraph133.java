package com.leetcode.Meetup.SolvedByOthers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * 
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/
Medium651705

Favorite

Share
Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

 

Example:



Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 

Note:

The number of nodes will be between 1 and 100.
The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
You must return the copy of the given node as a reference to the cloned graph.
 * 
 * @author rajat
 *
 */
class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode() {}

    public UndirectedGraphNode(int _val,List<UndirectedGraphNode> _neighbors) {
    	label = _val;
        neighbors = _neighbors;
    }
    public UndirectedGraphNode(int _val) {
    	label = _val;
        
    }
}
/* forsecond version*/
class Node {
    public int val;
    public List<Node> neighbors;
 
    public Node() {}
 
    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
 
public class CloneGraph133 {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	       
        if(node == null)
            return node;
       
        Map<UndirectedGraphNode, UndirectedGraphNode> map
            = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
       
       
        Queue<UndirectedGraphNode> que = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        que.offer(node);
       
        while(!que.isEmpty()){
            UndirectedGraphNode origNode = que.poll();
           
           for(UndirectedGraphNode neighbour : origNode.neighbors){
                UndirectedGraphNode cloned =null;
                if(!map.containsKey(neighbour)){
                    cloned = new UndirectedGraphNode(neighbour.label);
                    map.put(neighbour,  cloned);
                    que.add(neighbour);
                   
                }else {
                    cloned = map.get(neighbour);
                }
                map.get(origNode).neighbors.add(cloned);
            }
           
        }
       
        return clone;
       
       
       
    }
	
	public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            Node cloneNode = map.get(cur);
            for (Node itr: cur.neighbors) {
                if (!map.containsKey(itr)) {
                    map.put(itr, new Node(itr.val, new ArrayList<>()));
                    queue.offer(itr);
                }
                cloneNode.neighbors.add(map.get(itr));
            }
        }
        return map.get(node);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
