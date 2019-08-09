package com.leetcode.Meetup.SolvedByOthers;
/*
 * https://leetcode.com/problems/word-ladder/
 * 127. Word Ladder
Medium

1170

748

Favorite

Share
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * 
 * 
 */
public class WordLadder127 {
/**
 * Solution one in ppython
 * class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
       :type beginWord: str
       :type endWord: str
       :type wordList: List[str]
       :rtype: int
       """
        def diffByOne(y,z):
            count = 0
            for c1, c2 in zip(y,z):
               if (c1 != c2):
               count +=1
               if count > 1: break
            return count == 1
 
        class Node(object):
            def __init__(self, val):
                self.val = val
                self.visited = []
                self.nextNodes = []
 
        origin = Node(beginWord)
        origin.vistied = [origin]
        allNodes = [origin]
        endNode = None
        for word in wordList:
            nnode = Node(word)
            if word == endWord:
                endNode = nnode
            for node in allNodes:
                if (diffByOne(nnode.val, node.val)):
                    nnode.nextNodes.append(node)
                    node.nextNodes.append(nnode)
           
        allNodes.append(nnode)
   
        finalPath = []
        toTraverse = [origin]
 
        while toTraverse:
            node = toTraverse.pop(0)
            for nextNode in node.nextNodes:
                if (not nextNode.visited or len(nextNode.visited) > len(nextNode.visited) +1):
                   # found a shorter path
                    nextNode.visited = node.visited + [nextNode]
                    toTraverse.append(nextNode)
                   
        if (endNode and endNode.visited):
            #print [ n.val  for n in endNode.visited]
               return len(endNode.visited) +1
        return 0
 * 
 * @param args
 */
	
	/***
	 * Solution 2 in python
	 * def ladderLength(self, beginWord: 'str', endWord: 'str', wordList: 'List[str]') -> 'int':
        ## Build a undirected graph, connecting two words that are one edit away O(k*n^2), k is the length of the word
        ## Use hash trick, one can reduce to O(k*n), eg. hot can be put into {_ot: [hot], h_t: [hot], ho_: [hot]}
        hmap = collections.defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                hmap[word[:i] + '_' + word[i+1:]].append(word)
               
        def getNeighbors(word, hmap):
            result = set()
            for i in range(len(word)):
                for w in hmap[word[:i] + '_' + word[i+1:]]:
                    if w != word:
                        result.add(w)
            return result
                       
       
        ## BFS to find the shortest path length from start to goal.
        Q = [beginWord]
        visited = set()
        level = 0
        while Q:
            Q_size = len(Q)
            level += 1
            for i in range(Q_size):
                cur_node = Q.pop(0)
                visited.add(cur_node)
                if cur_node == endWord:
                    return level
                # Get neighbors and push into Q
                neighbors = getNeighbors(cur_node, hmap)
                for nei in neighbors:
                    if nei not in visited:
                        Q.append(nei)
                       
        return 0
	 * 
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
