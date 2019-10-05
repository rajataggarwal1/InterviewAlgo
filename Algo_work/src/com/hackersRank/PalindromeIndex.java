package com.hackersRank;
/*
 * https://www.hackerrank.com/challenges/palindrome-index/problem
 * Easy
 * Given a string of lowercase letters in the range ascii[a-z], determine a character that can be removed to make the string a palindrome. There may be more than one solution, but any will do. For example, if your string is "bcbc", you can either remove 'b' at index  or 'c' at index . If the word is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to remove.

Function Description

Complete the palindromeIndex function in the editor below. It must return the index of the character to remove or .

palindromeIndex has the following parameter(s):

s: a string to analyze
Input Format

The first line contains an integer , the number of queries.
Each of the next  lines contains a query string .

Constraints

All characters are in the range ascii[a-z].
Output Format

Print an integer denoting the zero-indexed position of the character to remove to make  a palindrome. If  is already a palindrome or no such character exists, print .

Sample Input

3
aaab
baa
aaa
Sample Output

3
0
-1
Explanation

Query 1: "aaab"
Removing 'b' at index  results in a palindrome, so we print  on a new line.

Query 2: "baa"
Removing 'b' at index  results in a palindrome, so we print  on a new line.

Query 3: "aaa"
This string is already a palindrome, so we print . Removing any one of the characters would result in a palindrome, but this test comes first.

Note: The custom checker logic for this challenge is available here.
 * 
 */
public class PalindromeIndex {
	// removing each elemnt from given string and check with rest string if it is palindrom
	static int palindromeIndex(String s) {
        if(s.length()<=1 || checkPalindrom(s))
        {
            return -1;
        }
        for(int i=0; i< s.length(); i++)
        {
            String str1=s.substring(0,i);
           // System.out.println(str1);
            String str2=s.substring(i+1, s.length());
           // System.out.println(str2);
            if(checkPalindrom(str1+str2))
            {
                return i;
            }

        }

        return -1;

}

    public static boolean checkPalindrom(String s)
    {
        int i=0;
        int j=s.length()-1;

        while(i<j)
        {
            if(s.charAt(i)== s.charAt(j))
            {
                i++;
                j--;
                continue;
            }
            else
            {
                return false;
            }
        }

        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PalindromeIndex p=new PalindromeIndex();
		System.out.println(palindromeIndex("aaab"));
		System.out.println(palindromeIndex("baa"));
		System.out.println(palindromeIndex("aaa"));
		System.out.println(palindromeIndex("abcdefghijklmnopqrstuvwxyz"));
	}

}
