package com.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 394. Decode String
Medium

1256

70

Favorite

Share
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 * 
 * 
 */
public class DecodeString394 {
	public String decodeString(String s) {
        
		Stack stack=new Stack();
		String strToPush="";
		int stringLength=s.length();
		
		for(int i=0; i< stringLength; i++)
		{
			
			if(s.charAt(i) == ']')
			{
				
			}
			else
			{
				
				while(s.charAt(i) >= 'a' && s.charAt(i) <='z')
				{
					char ch=s.charAt(i);
					strToPush=strToPush  +ch;
					i++;
				}
				if(strToPush.length()>0)
					stack.push(strToPush);
				else
					stack.push(s.charAt(i));
			}
		}
		
		
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeString394 d=new DecodeString394();
		String s1="3[a]2[bc]";
		String s2="3[a2[c]]";
		String s3="2[abc]3[cd]ef";
		System.out.println(d.decodeString(s1));

	}

}
