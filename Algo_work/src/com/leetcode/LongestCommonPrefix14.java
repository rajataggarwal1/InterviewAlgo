package com.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/longest-common-prefix/
 * 14. Longest Common Prefix
Easy

1214

1218

Favorite

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z
 * 
 * 
 */
public class LongestCommonPrefix14 {
	public String longestCommonPrefix(String[] strs) {
        boolean flag=true;
        String returnString="";
       
       
        if(strs.length < 1)
            return "";
        else if(strs.length == 1)
        {
            return strs[0];
        }
        
        // Sorting of array is most important as we get minimum size string at first
        // we will run loop to the size of first string to findout longest common prifix
        Arrays.sort(strs);
        
        for(int i=0; i< strs[0].length();i++)
        {
            char charToMatch=strs[0].charAt(i);
            
            for(int j=1; j<strs.length; j++)
            {
                
               // System.out.println("charToMatch " +charToMatch +"  strs[j].charAt(i) " +strs[j].charAt(i));
                // Check if char match then set flag thre else set flag false and break the loop.
                   if(strs[j].charAt(i)==charToMatch)
                    {
                        flag=true;
                    }
                    else
                    {
                        flag=false;
                        break;
                    }
            }
            
            if(flag==true)
            {
                returnString+=charToMatch;
            }
            else
            {
                break;
            }
            
        }
        
        
        return returnString;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix14 l= new LongestCommonPrefix14();
		String strs[]= {"flower","flow","flight"};
		System.out.println(l.longestCommonPrefix(strs));
		
		String strs1[]= {"dog","racecar","car"};
		System.out.println(l.longestCommonPrefix(strs1));
		
		String strs2[]= {"flower","flow","f"};
		System.out.println(l.longestCommonPrefix(strs2));
		
	}

}
