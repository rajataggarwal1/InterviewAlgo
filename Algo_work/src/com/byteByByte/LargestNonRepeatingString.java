package com.byteByByte;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Find the Longest Nonrepeating Substring from given string, return the length of max string
 * 
 * Ex : abcabcbb
 * Lasgest is : abc or cab
 * 
 * Max length =3
 * 
 */
public class LargestNonRepeatingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNonRepeatingString l=new LargestNonRepeatingString();
		System.out.println(l.findLongestNonRepeatingString("abcabcbb"));
		System.out.println(l.findLongestNonRepeatingString("bbbbb"));
		System.out.println(l.findLongestNonRepeatingString("pwwkew"));
		System.out.println(l.findLongestNonRepeatingString(""));
		System.out.println(l.findLongestNonRepeatingString(" "));
		System.out.println(l.findLongestNonRepeatingString("au"));
		System.out.println(l.findLongestNonRepeatingString("dvdf"));
		System.out.println(l.findLongestNonRepeatingString("tmmzuxt"));
		System.out.println(l.findLongestNonRepeatingString("ohvhjdml")); //expected 6
		
		// wrong answer - I need to think another approach
		System.out.println(l.findLongestNonRepeatingString("aabaab!bb")); //expected 3 returning 2
		System.out.println(l.findLongestNonRepeatingString("museuwzbczdejn")); //expected 7 returning 8
		
		System.out.println(l.lengthOfLongestSubstring("aabaab!bb")); //expected 3 returning 2
		System.out.println(l.lengthOfLongestSubstring("museuwzbczdejn")); //expected 7 returning 8
	}

	// Implementing two pointer approach
	public int findLongestNonRepeatingString(String str)
	{	
		
		Map<Character, Integer> charMap=new LinkedHashMap<Character, Integer>();		
		
		int i=0;
		int j=0;
		
		int longestSoFar=0;
		int longest=0;
		// Tqo pointer approach
		while(j< str.length())
		{
			// encountered duplicate value
			if(charMap.containsKey(str.charAt(j)))
			{
				int cnt=charMap.get(str.charAt(j));
				charMap.put(str.charAt(j), cnt+1);
				j++;
				
				//System.out.println(charMap);
				// Removing duplicate value from map by going thru the already build map using J. and keep 
				//incrementing i until first element greater then 1 found decrement it and break
				if(cnt > 0)
				{
					for(Map.Entry<Character,Integer> entries:charMap.entrySet())
					{
						if(str.charAt(i) == entries.getKey())
						{
							int tmpVal=entries.getValue();
							charMap.put(str.charAt(i), entries.getValue()-1);
							i++;						
							if(tmpVal > 1)
							{
								break;
							}
						}
					}
				}
				
				
			}
			else
			{
				charMap.put(str.charAt(j), 1);
				j++;
			}
			
			// Going thru the map to find the unique element to return the longest non repeating string
			longestSoFar=0;
			for(Map.Entry<Character,Integer> entries:charMap.entrySet())
			{
				if(entries.getValue() == 1)
				{
					longestSoFar++;
				}
			}
			if(longestSoFar > longest)
			{
				longest = longestSoFar;
				longestSoFar=0;
			}
			
		}
			
		return longest;
	}
	
	
	// Slinding window approach taken from leetcode solution
	 public int lengthOfLongestSubstring(String s) {
	        int n = s.length();
	        Set<Character> set = new HashSet<Character>();
	        int ans = 0, i = 0, j = 0;
	        while (i < n && j < n) {
	            // try to extend the range [i, j]
	            if (!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));
	                ans = Math.max(ans, j - i);
	            }
	            else {
	                set.remove(s.charAt(i++));
	            }
	        }
	        return ans;
	    }
	
	/* Approach 3: Sliding Window Optimized
	 The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. Instead of using a set to
	 tell if a character exists or not, we could define a mapping of the characters to its index. Then we can skip the characters 
	 immediately when we found a repeated character.
	 The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'j 	 
	  , we don't need to increase ii little by little. We can skip all the elements in the range [i, j'][i,j 	 
	  ] and let ii to be j' + 1j    +1 directly.

	 Java (Using HashMap)*/
	 public int lengthOfLongestSubstring1(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	    }
	
}
