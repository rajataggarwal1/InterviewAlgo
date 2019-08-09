package com.leetcode;

import java.util.Arrays;

/*
 * 242. Valid Anagram
Easy

619

93

Favorite

Share
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * 
 * 
 */
public class ValidAnagram242 {
	public boolean isAnagram(String s, String t) {
        char sArr[]=s.toCharArray();
        char tArr[]=t.toCharArray();
        // Covert both string into char array and then sort. Break the look if not equal.
        // As per question length should be same.
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        
        boolean isExist=true;
        
        if(s.length() != t.length())
            return false;
        
        for(int i=0; i< sArr.length; i++)
        {
            if(sArr[i]!= tArr[i])
            {
                isExist=false;
                break;
            }
        }
        
         
        return isExist;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidAnagram242 v=new ValidAnagram242();
		
		System.out.println("result: "+v.isAnagram("anagram", "nagaram"));
		System.out.println("result: "+v.isAnagram("rat", "car"));
		System.out.println("result: "+v.isAnagram("a", "aa"));
	}

}
