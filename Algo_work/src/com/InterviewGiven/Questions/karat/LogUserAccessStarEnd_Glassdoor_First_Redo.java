package com.InterviewGiven.Questions.karat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

/*
 * // Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID. 

// The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

// For example:
// logs = [
//     ["58523", "user_1", "resource_1"],
//     ["62314", "user_2", "resource_2"],
//     ["54001", "user_1", "resource_3"],
//     ["215", "user_6", "resource_4"],
//     ["200", "user_6", "resource_5"],    
//     ["54060", "user_2", "resource_3"],
//     ["53941", "user_3", "resource_3"],
//     ["58522", "user_4", "resource_1"],
//     ["53651", "user_5", "resource_3"],
//     ["2", "user_6", "resource_3"],
//     ["100", "user_6", "resource_6"],
//     ["400", "user_7", "resource_2"],
//     ["100", "user_8", "resource_2"],
// ]


// We would like to compute user sessions, specifically: write a function that takes the logs and returns a data structure that associates to each user their earliest and latest access times.

// Example:
// {'user_1': [54001, 58523], 
//  'user_2': [54060, 62314], 
//  'user_3': [53941, 53941], 
//  'user_4': [58522, 58522], 
//  'user_5': [53651, 53651], 
//  'user_6': [2, 215], 
//  'user_7': [400, 400], 
//  'user_8': [100, 100]}
 * 
 */
public class LogUserAccessStarEnd_Glassdoor_First_Redo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 String[][] logs = new String[][] {
		        { "58523", "user_1", "resource_1" },
		        { "62314", "user_2", "resource_2" },
		        { "54001", "user_1", "resource_3" },
		        { "215", "user_6", "resource_4" },
		        { "200", "user_6", "resource_5" },
		        { "54060", "user_2", "resource_3" },
		        { "53941", "user_3", "resource_3" },
		        { "58522", "user_4", "resource_1" },
		        { "53651", "user_5", "resource_3" },
		        { "2", "user_6", "resource_3" },
		        { "100", "user_6", "resource_6" },
		        { "400", "user_7", "resource_2" },
		        { "100", "user_8", "resource_2" }
		    };
		    
		    LogUserAccessStarEnd_Glassdoor_First_Redo log=new LogUserAccessStarEnd_Glassdoor_First_Redo();
		    HashMap<String, ArrayList<Integer>> result =log.findTime(logs);
		    
		    System.out.println(result);

	}
	
	 public HashMap<String, ArrayList<Integer>> findTime(String [][]logs)
	  {
	    
	    HashMap<String, ArrayList<Integer>> map=new HashMap<String, ArrayList<Integer>>();
	    
	    for(int i=0; i< logs.length; i++)
	    {
	      if(map.containsKey(logs[i][1]))
	      {
	        ArrayList<Integer> lst=map.get(logs[i][1]);
	        lst.add(Integer.parseInt(logs[i][0]));
	        map.put(logs[i][1],lst);
	        
	      }
	      else
	      {
	        
	        ArrayList<Integer> lst=new ArrayList<Integer>();
	        lst.add(Integer.parseInt(logs[i][0]));
	        
	        map.put(logs[i][1],lst);
	      }
	      
	    }
	    
	    for(Entry<String, ArrayList<Integer>> entry:map.entrySet())
	    {
	       
	        ArrayList<Integer> lst=entry.getValue();
	      Collections.sort(lst);
	       ArrayList<Integer> newList=new ArrayList<Integer>();
	      
	     
	        newList.add(lst.get(0));
	         newList.add(lst.get(lst.size()-1));
	    
	      map.put( entry.getKey(),newList );
	      
	    }
	    
	    return map;
	    
	  }

}
