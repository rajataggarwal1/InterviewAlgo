package com.leetcode;
/*
 * 387. First Unique Character in a String
Easy

839

70

Favorite

Share
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 * 
 * 
 */
public class FirstUniqueCharacterInString387 {
public int firstUniqChar(String s) {
        
        char charArray[]= s.toCharArray();
        
        
        int nonRepeatLocation=-1;
        boolean found=false;
        
        for(int i=0; i< charArray.length-1; i++)
        {
            nonRepeatLocation=i;
            found=false;
            for(int j=i+1; j <charArray.length; j++)
            {
             if(charArray[i]==charArray[j])
             {
                 found=true;
                 nonRepeatLocation=-1;
                 break;
             }
             
           }
            
            if(!found)
            {
            	nonRepeatLocation=i;
                break;
            }
             
        }
        
        
        return nonRepeatLocation;
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstUniqueCharacterInString387 f=new FirstUniqueCharacterInString387();
		
		System.out.println(f.firstUniqChar("leetcode"));
		System.out.println(f.firstUniqChar("loveleetcode"));
		System.out.println(f.firstUniqChar("ccc"));
		System.out.println(f.firstUniqChar("aadadaad"));
	}

}
