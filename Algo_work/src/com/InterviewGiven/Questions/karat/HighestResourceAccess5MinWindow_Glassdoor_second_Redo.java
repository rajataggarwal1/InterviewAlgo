package com.InterviewGiven.Questions.karat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

/*
 * // Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

// Example:
// ('resource_3', 3)

 * 
 */
public class HighestResourceAccess5MinWindow_Glassdoor_second_Redo {

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
	    
	    HighestResourceAccess5MinWindow_Glassdoor_second_Redo s=new HighestResourceAccess5MinWindow_Glassdoor_second_Redo();
	    
	    HashMap<String, Integer> result =s.findTime(logs);
	    
	    System.out.println(result);


	}

	public HashMap<String, Integer> findTime(String [][]logs)
	  {
	    
	    HashMap<String, ArrayList<Integer>> map=new HashMap<String, ArrayList<Integer>>();
	    // building hasmap having list of all timestamp
		for(int i=0; i< logs.length; i++)
		{
		  if(map.containsKey(logs[i][2]))
		  {
		    ArrayList<Integer> lst=map.get(logs[i][2]);
		    lst.add(Integer.parseInt(logs[i][0]));
		    map.put(logs[i][2],lst);
		    
		  }
		  else
		  {
		    
		    ArrayList<Integer> lst=new ArrayList<Integer>();
		    lst.add(Integer.parseInt(logs[i][0]));
		    
		    map.put(logs[i][2],lst);
		  }
		  
		}

		int countsofar=0;
		int maxcount=0;

	    // going thru hashmap and sorting list and buiding result passing list to get max count
	    HashMap<String, Integer> returnMap=new HashMap<String, Integer>();
	    String key="";
	    for(Entry<String, ArrayList<Integer>> entry:map.entrySet())
	    {
	       
	        ArrayList<Integer> lst=entry.getValue();
	        Collections.sort(lst);
	      
			countsofar=findMax(lst);
			   
			      //System.out.println(max);
			  if(countsofar > maxcount)
			  {
			    maxcount=countsofar;
			    key=entry.getKey();
			    countsofar=0;
			  }
			}
	    returnMap.put(key,maxcount);
	    return returnMap;
	    
	  }
	  
	// passing arraylist and getting max count in 5 min span
	  public int findMax(ArrayList<Integer> ls){
	    
	    int fivemin=300;
	    int countsofar=0;
	    int maxcount=0;
	    
	    for(int i=0; i< ls.size(); i++)
	    {
	      int firsTime=ls.get(i) + fivemin;
	 
	      countsofar=0;
	      for(int j=i; j< ls.size() ; j++)
	      {
	         if(ls.get(j) < firsTime)
	         {
	           countsofar++;
	         }
	         else{
	           break;
	         }
	      }
	      
	      
	      if(countsofar > maxcount)
	      {
	        maxcount=countsofar;
	        countsofar=0;
	      }
	      
	    }
	    
	    return maxcount;
	  }
	  
	
	
}
