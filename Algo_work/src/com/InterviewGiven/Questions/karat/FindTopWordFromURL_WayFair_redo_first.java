package com.InterviewGiven.Questions.karat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


/*
https://public.karat.io/content/q093/wordlist.txt

The text file at the URL above lists common words in English, together with a count of their occurrence in a certain text. It is tab-delimited and newline-separated. The file is sorted with most common words at the top. 

Write a function that, given parameters N and K, downloads the file and returns the N most common words of length [2..K] together with their occurrence counts.

# Sample usage with maximum word length 5, to find top 1000 words:
get_list(1000, 5)

# Expected output (in order, pseudodata):
[
  ['THE', 53097401461],
  ['OF',  30966074232],
  ['AND', 22632024504],
  # ...
  ['OWNED', 30008173],
  ['VARY', 29995673],
  ['AXIS', 29993153]
]
*/


public class FindTopWordFromURL_WayFair_redo_first {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		FindTopWordFromURL_WayFair_redo_first s=new FindTopWordFromURL_WayFair_redo_first();
		String [][] result=s.findMostWord(1000, 5);
        
		//Printing top 3 and bottom three out of 1000 word of size between 2 and 5 including 2 and five
	    for(int  i=0; i < 3; i++)
	     {
	    	System.out.println(result[i][0] + " "+ result[i][1]);
	     }
	     for(int  i=result.length-1; i > 996; i--)
	     {
	    	 System.out.println(result[i][0] + " "+ result[i][1]);
	     }
	}
	
	public String[][] findMostWord(int totalWord, int k) throws IOException
	  {
	    // input the file and read 	  
	    URL fileUrl=new URL("https://public.karat.io/content/q093/wordlist.txt");
	    BufferedReader bf= new BufferedReader(new InputStreamReader(fileUrl.openStream()));
	    
	    String line;
	    String [][] result=new String[totalWord][2];
	    
	    int rowcount=0;
	    
	    // Going thru line by line and breaking the line into array to process the data
	    while((line = bf.readLine()) !=null)
	    {
	      String temp[]= line.split("\\t");
	      //System.out.println(temp[0] + " "+ temp[1]);
	      
	      if(temp[0].length() >= 2 && temp[0].length() <= k)
	      {
	        result[rowcount][0]= temp[0];
	        result[rowcount++][1]= temp[1];
	        
	      } 
	      if(rowcount >= totalWord)
	      {
	        bf.close();
	        break;
	      }
	      
	      
	      
	    }
	    
	    
	    return result;
	    
	    
	    // find the top word count and build return array
	    
	    
	    
	  }

}
