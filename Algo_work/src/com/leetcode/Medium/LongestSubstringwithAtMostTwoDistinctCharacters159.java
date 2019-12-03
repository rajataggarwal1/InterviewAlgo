package com.leetcode.Medium;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 159. Longest Substring with At Most Two Distinct Characters
Medium

677

14

Favorite

Share
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
 * 
 * 
 * 
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters159 {

public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        // solution is extention of 3. Longest Substring Without Repeating Characters
        // Use hashmap to store the count of character and restricted map size to 2
        // so that we can fullfill atmost two unique character condition.
        // Using in I and J for sliding window where keep moving j until size less then 2 or found second character.
        // move I as soon as thid character found and keep reducing count and remove once count became zero
        // after each iteration do j-i to find length.
        
        if(s.length() <=1)
            return s.length();
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        
        int i=0;
        int j=0;
        int result = Integer.MIN_VALUE;
        
        while(i< s.length() || j< s.length())
        {   
            if(j< s.length() && map.size()<2)
            {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
                j++;                
            }
            else
            {
                if(j< s.length() && map.containsKey(s.charAt(j)))
                {
                    int cnt=map.get(s.charAt(j));
                    cnt++;
                    map.put(s.charAt(j), cnt);
                    j++;                     
                }
                else
                {                     
                    if(map.containsKey(s.charAt(i)))
                    {                         
                        int cnt=map.get(s.charAt(i));
                        cnt--;
                        if(cnt==0)
                            map.remove(s.charAt(i));
                        else
                        {
                            map.put(s.charAt(i), cnt);
                        }
                        i++;
                    }
                }
            }
            
           //   System.out.println("map "+ map);
            int maxsofar=j-i;
           // System.out.println("maxsofar "+ maxsofar);
            if(result < maxsofar )
            {
                result=maxsofar;
            }
            
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringwithAtMostTwoDistinctCharacters159 l=new LongestSubstringwithAtMostTwoDistinctCharacters159();
		
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("abcabcbb"));
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
	}

}
