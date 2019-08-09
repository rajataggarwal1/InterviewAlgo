package com.leetcode;
/*
 * 744. Find Smallest Letter Greater Than Target
Easy

193

290

Favorite

Share
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
 * 
 * 
 */
public class FindSmallestLetterGreaterThanTarget744 {
	public char nextGreatestLetter(char[] letters, char target) {
        char retunChar='a';
        for(int i=0;i<letters.length;i++)
        {
            if(letters[i]>target)
            {
                retunChar= letters[i];
                break;
            }
            
            if(i==letters.length-1)
            {
                retunChar= letters[0];
            }
        }
        
        return retunChar;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSmallestLetterGreaterThanTarget744 small=new FindSmallestLetterGreaterThanTarget744();
		
		char arr[]= {'c', 'f', 'j'};
		System.out.println("next char is "+small.nextGreatestLetter(arr, 'a'));
	}

}
