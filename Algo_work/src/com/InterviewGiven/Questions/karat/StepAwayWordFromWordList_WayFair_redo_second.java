package com.InterviewGiven.Questions.karat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://public.karat.io/content/q093/wordlist.txt

Given two strings s1 and s2, we will call (s1, s2) a "step" if you can form s2 by adding exactly one letter to s1 and possibly rearranging the letters of s1.

For example:
(of, for) is a step
(of, if) is not a step
(of, oct) is not a step
(era, ear) is not a step

Given the 1000-word wordlist we just generated, produce an index
   w -> {  w1 | (w, w1) is a step } 
that associates to each word all the words in the wordlist that are a step away from it.

index = step_index(wordlist)

# Expected output (pseudocode):

index['ERA'] = ['REAL', 'RARE', 'AREA', 'READ', 'RATE', 'BEAR', 'NEAR', 'RACE', 'HEAR', 'YEAR', 'DEAR', 'FEAR', 'CARE']


index['JOY'] = []

// Approach
Create Map of the input string with count
Read the file line by line and check string with is first element of two part string with length +1.
If length is greater then +1(Because we are checking one step away string) then skip. else check whether 
all character exist in file string. If yes and hashmap size is 0 then add into return string 

map(key as char, val as count)

*/
// We need to reuse code of FindTopWordFromURL_WayFair_redo_first
public class StepAwayWordFromWordList_WayFair_redo_second {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StepAwayWordFromWordList_WayFair_redo_second f=new StepAwayWordFromWordList_WayFair_redo_second();
		
		List<String> result=f.findExactOneString("ERA");
		System.out.println("ERA " + result);
		
		System.out.println("JOY " + f.findExactOneString("JOY"));
		System.out.println("RAJA " + f.findExactOneString("RAJA"));
	}
	
	public List<String> findExactOneString(String word) throws IOException
	{
		// Map the word in HasMap with its character count
		Map<Character, Integer> charMap=new HashMap<Character,Integer>();
		
		// building map
		for(int i=0; i< word.length(); i++)
		{
			charMap.put(word.charAt(i), charMap.getOrDefault( word.charAt(i), 0)+1 );			
			
		}
		
		List<String> result=new ArrayList<String>();
		// reading file url
		URL fileUrl=new URL("https://public.karat.io/content/q093/wordlist.txt");
		BufferedReader bf= new BufferedReader(new InputStreamReader(fileUrl.openStream()));
		String line;
		
			// reusing code of find top 1000 words logic 				
				// going thru file line by line    
			    while((line = bf.readLine()) !=null)
			    {
			    	String temp[]= line.split("\\t");
			    	
			    	// if size greater then continue
			    	if(!(temp[0].length() == word.length()+1 ))
			    	{
			    		continue;
			    	}
			    	
			    	// creating temp map to check with each upcoming string
			    	Map<Character, Integer> tempMap=new HashMap<Character,Integer>();
			    	tempMap.putAll(charMap); 
			    	
			    	for(int i=0; i< temp[0].length(); i++)
					{
			    		// checking in map and remove and decreasing the count
			    		if(tempMap.containsKey(temp[0].charAt(i)))
			    		{
			    			int charCount=tempMap.get(temp[0].charAt(i));
			    			charCount--;
			    			if(charCount == 0)
			    			{
			    				tempMap.remove(temp[0].charAt(i));
			    			}
			    			else
			    			{
			    				tempMap.put(temp[0].charAt(i), charCount);
			    			}
			    			
			    		}
					}
			    	
			    	// building result
			    	if(tempMap.size() == 0)
			    	{
			    		result.add(temp[0]);
			    	}
			    	
			    }
		
				bf.close();
			
		return result;
		    
	}

}
