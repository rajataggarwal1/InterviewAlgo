package com.leetcode;

import java.util.HashMap;

/*
 * 
 * 345. Reverse Vowels of a String
Easy

369

663

Favorite

Share
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".

 
 * 
 * 
 */
public class ReverseVowelsOfAString345 {
public String reverseVowels(String s) {
        
        if(s.length()<=1)
        {
            return s;
        }
        
       // Converting string in to char array
        char cArr[]=s.toCharArray();
        
        int i=0;
        int j=s.length()-1;
        //defining viwels map
        HashMap map=new HashMap();
        map.put('a','a');
        map.put('e','e');
        map.put('i','i');
        map.put('o','o');
        map.put('u','u');
        
     
        while(i<=j)
        {
            char ch1=cArr[i];
            char ch2=cArr[j];
            
            //checking map convertin into lower case becaus value can be in upper case.
            if(map.containsKey(Character.toLowerCase(ch1)) !=true)
            {
                i++;
            }
            
            if(map.containsKey(Character.toLowerCase(ch2)) !=true)
            {
                j--;
            }
            
            
            if(map.containsKey(Character.toLowerCase(ch1)) ==true && map.containsKey(Character.toLowerCase(ch2)) == true )
            {
                char temp=ch1;
                cArr[i]=cArr[j];
                cArr[j]=temp;
                i++;
                j--;
            }
        }
        
        //converting Char array to String
        String returnString=new String(cArr);
        
        return returnString;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseVowelsOfAString345 r=new ReverseVowelsOfAString345();
		System.out.println(r.reverseVowels("leetcode"));
		System.out.println(r.reverseVowels("hello"));
		System.out.println(r.reverseVowels("aA"));
	}

}
