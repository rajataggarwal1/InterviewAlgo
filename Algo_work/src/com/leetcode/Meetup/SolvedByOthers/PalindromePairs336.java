package com.leetcode.Meetup.SolvedByOthers;
/***https://leetcode.com/problems/palindrome-pairs/
 * 
 * 336. Palindrome Pairs
Hard

646

82

Favorite

Share
Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]
 * 
 * 
 * 
 * 
 * 
 * @author rajat
 *
 */
public class PalindromePairs336 {
	 public IList<IList<int>> PalindromePairs(string[] words) {
		    IList<IList<int>> result = new List<IList<int>>();

		    for (int i = 0; i < words.Length - 1; i++)
		      for (int j = i + 1; j < words.Length; j++) {
		        if (IsPalindrome(words[i] + words[j]))
		          result.Add(new List<int>(new[] { i, j }));
		        if (IsPalindrome(words[j] + words[i]))
		          result.Add(new List<int>(new[] { j, i }));
		      }

		    return result;
		  }

		  private bool IsPalindrome(string s) {
		    for (int i = 0, j = s.Length - 1; i < j; i++, j--)
		      if (s[i] != s[j])
		        return false;
		    return true;
		  }
		  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
