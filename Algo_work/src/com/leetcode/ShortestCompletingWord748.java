package com.leetcode;

import java.util.HashMap;

/*
 * 748. Shortest Completing Word
Easy

98

373

Favorite

Share
Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
Note:
licensePlate will be a string with length in range [1, 7].
licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
words will have a length in the range [10, 1000].
Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 * 
 * 
 * 
 */
public class ShortestCompletingWord748 {

	/**
	 * @param args
	 */
	
	 public String shortestCompletingWord(String licensePlate, String[] words) {
	        
	        char convertToChar[]= licensePlate.toCharArray();
	        
	        HashMap map= new HashMap();
	        
	        //first loop to get only valid char with count
	          //char val;
	        
	        for(int i=0; i<convertToChar.length; i++)
	        {
	              char val=Character.toLowerCase(convertToChar[i]);
	            
	            if(val >= 'a' && val <='z' )
	            {
	            
	                if(map.containsKey(val))
	                {
	                    int cnt=(Integer)(map.get(val));
	                    map.put(val, cnt+1);

	                }
	                else
	                {
	                    map.put(val,1);
	                }
	            }
	        }
	        
	        
	        // second loop for iterating word to check whether licenseplate exist or not
	        int returnindex=-1;
	        int returnLength=0;
	        for(int i=0; i<words.length; i++)
	        {
	            
	            String strToCompare=words[i];
	            HashMap tempMap= new HashMap();
	            //tempMap=map;
	            
	            tempMap.putAll(map);
	            
	          int tempLength=strToCompare.length();
	            
	            for(int j=0; j<strToCompare.length(); j++ )
	            {
	                char charTocheck=Character.toLowerCase(strToCompare.charAt(j));
	               
	                
	                if(tempMap.containsKey(charTocheck))
	                {
	                     int val=(Integer)tempMap.get(charTocheck);
	                    if((val-1)==0)
	                    {
	                        tempMap.remove(charTocheck);
	                    }
	                    else
	                    {
	                        tempMap.put(charTocheck, val-1);
	                    }
	                    
	                }
	                
	            }
	            
	            if(tempMap.size()==0)
	            {
	                if(returnindex==-1 || tempLength<words[returnindex].length())
	                {
	                    returnindex=i;
	                    
	                }
	                
	            }
	                
	            
	            
	        }
	        
	        return words[returnindex];
	        
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestCompletingWord748 s=new ShortestCompletingWord748();
		String []words={"step", "steps", "stripe", "stepple"};
		
		System.out.println(s.shortestCompletingWord("1s3 PSt",words ));
	}

}
