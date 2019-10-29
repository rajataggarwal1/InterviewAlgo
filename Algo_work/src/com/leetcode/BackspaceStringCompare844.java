package com.leetcode;
/*
 * https://leetcode.com/problems/backspace-string-compare/
 * 844. Backspace String Compare
Easy

849

51

Favorite

Share
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 * 
 * 
 */

import java.util.Stack;

public class BackspaceStringCompare844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackspaceStringCompare844 s=new BackspaceStringCompare844();
		
		System.out.println(s.backspaceCompare("a#c", 
				"b"));
		System.out.println(s.backspaceCompare("a##c", 
				"#a#c"));

	}
	public boolean backspaceCompare(String S, String T) {
	       
        // Solved using stack. Keep pusing until found first hash
        // Start poping the element once found first hash.
        // Need to add special condition if encountered # at first place.
        // do not pop becaus estack is empty
        
        
        String str1=processString(S);
        String str2=processString(T);
        
      return str1.equalsIgnoreCase(str2);
       
   }
   
   public String processString(String str)
   {
       Stack<Character> stk= new Stack<Character>();
       
       int i=0;
       
       while(i < str.length())
       {
           if(str.charAt(i)== '#')
           {
               if(!stk.empty())
               {
                    stk.pop();
               }               
               
           }
           else
           {
               stk.push(str.charAt(i));
           }
           
           i++;
       }
       
       String resturnString="";
       
       while(stk.size()>0)
       {
           resturnString+= Character.toString(stk.pop());
           
       }
       
       return resturnString;
   }

}
