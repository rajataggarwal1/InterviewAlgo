package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 443. String Compression
Easy

311

919

Favorite

Share
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.

 
Follow up:
Could you solve it using only O(1) extra space?

 
Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 

Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
 

Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
 

Note:

All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.
 * 
 * 
 */
public class StringCompression443 {
	public int compress(char[] chars) {
		  
        int count=0;
        int modifyArrCounter=0;
        
        char charToCompare=chars[0];
        
        if(chars.length<=1)
        	return chars.length;
        
        for(int i=0; i< chars.length; i++)
        {
            if(charToCompare==chars[i])
            {
                count++;
                //if(i< chars.length-1)
                	continue;
            }
           
                chars[modifyArrCounter++]=chars[i-1];
                if(count>= 10)
                {
                   
                    String sCount=String.valueOf(count);
                    char countArr[]=sCount.toCharArray();
                    
                    for(int j=0; j<countArr.length; j++)
                    {
                         chars[modifyArrCounter++]=countArr[j];
                    }
                    
                    count=0;
                }
                else
                {
                    if(count!=1)
                    {
                        chars[modifyArrCounter++]=(char)(count+'0'); ;
                         count=0;
                    }
                }
                charToCompare=chars[i--];
             /*   if(i< chars.length-1)
                {
                	i--;
                }
                else if(i >= chars.length-1 )
                {
                	 chars[modifyArrCounter]=chars[i];
                }*/
            
        }
          // Doing everything again for last loop  
        chars[modifyArrCounter++]=charToCompare;
        if(count>= 10)
        {
           
            String sCount=String.valueOf(count);
            char countArr[]=sCount.toCharArray();
            
            for(int j=0; j<countArr.length; j++)
            {
                 chars[modifyArrCounter++]=countArr[j];
            }
            
            count=0;
        }
        else
        {
            if(count!=1)
            {
                chars[modifyArrCounter++]=(char)(count+'0'); ;
                 count=0;
            }
        }
        
        
        
        //---------------------------------------------------
        return chars.length;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//char [] cahrArr= {'a','a','b','b','c','c','c'};
//		char [] cahrArr= {'a','b','b','c','c','c'};
//char [] cahrArr= {'a'};
//char [] cahrArr= {'a','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','a'};
//	 char [] cahrArr= {'a','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','b','b','b','b','b','b'};
//		char [] cahrArr= {'a','a', 'b','b'};
//char [] cahrArr= {'a','b','b','c','c','c','c','c','c','c','c','c','c','a','b'};
char [] cahrArr= {'a','b', 'c'};
StringCompression443 s=new StringCompression443();

System.out.println( s.compress(cahrArr));



}
}
