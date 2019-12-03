package com.leetcode.Medium;

import java.util.HashSet;

/*
 * 
 * 3. Longest Substring Without Repeating Characters
Medium

7036

416

Favorite

Share
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 
 * 
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

public int lengthOfLongestSubstring(String s) {
        
        // Solution is using two pointer approach with hashSet
        // Keep moving j and updating hashSet with unique value. Move i if found duplicate
        // and keep deleting from set and increment i
        
        if(s.length() <=1)
            return s.length();
        
        
        int i=0; 
        int j=0;
        
        HashSet<Character> set=new HashSet<Character>();
        int result= Integer.MIN_VALUE;
        
        while(i< s.length() || j< s.length())
        {
                          
            if(j<s.length() && !set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j));
                j++;
            }
            else
            {
                set.remove(s.charAt(i));
                i++;
            }
            
            
            if(result< set.size())
            {
                result=set.size();
            }
            
            
            
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters3 s= new LongestSubstringWithoutRepeatingCharacters3();
		
		System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(s.lengthOfLongestSubstring("bbbbb"));
		System.out.println(s.lengthOfLongestSubstring("pwwkew"));
	}

}
