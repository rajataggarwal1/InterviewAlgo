package com.InterviewGiven.Questions.karat;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * https://leetcode.com/problems/subdomain-visit-count/
 * 
 * Approach :
 * // Go thru Array ->
    // Break the input  counter + domain
    // split the domain and start building my result
    // building map -> key will be domain and value is counter
    
    Expected output: Order does not matter
    1340 : com
    900 : google.com
    410 : yahoo.com
    60 : mail.yahoo.com
    50 : sports.yahoo.com
    20 : overflow.com
	10 : stackoverflow.com
	10 : mobile.sports.yahoo.com
	3 : org
	3 : wikipedia.org
	2 : en.wikipedia.org
	1 : sports
	1 : mobile.sports
	1 : uk
	1 : m.wikipedia.org
	1 : co.uk
	1 : google.co.uk
    
    
 */

public class DomainCounter_Zume_FirstQuestion_ReDo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] counts = {  
		"900,google.com",
	      "60,mail.yahoo.com",
	      "10,mobile.sports.yahoo.com",
	      "40,sports.yahoo.com",
	      "300,yahoo.com",
	      "10,stackoverflow.com",
	      "20,overflow.com",
	      "2,en.wikipedia.org",
	      "1,m.wikipedia.org",
	      "1,mobile.sports",
	      "1,google.co.uk"
	    };

		DomainCounter_Zume_FirstQuestion_ReDo s=new DomainCounter_Zume_FirstQuestion_ReDo();
	    
	    HashMap<String, Integer> result=s.calculateHits(counts);
	    
	    
	    for(Map.Entry<String, Integer> entries:result.entrySet())
	    {
	      System.out.println(entries.getValue() + " : " + entries.getKey());
	    }

	}
	
	
	public HashMap<String, Integer> calculateHits(String[] domain)
	  {
	  
	    
	    HashMap<String, Integer> map=new HashMap<String, Integer>();
	      System.out.println(domain.length);
	    for(int i=0; i< domain.length; i++)
	    {
	      String arr[]= domain[i].split(",");
	    //  System.out.println(arr[0] + " " + arr[1]);
	      
	      String domainSplit[]=arr[1].split("\\.");
	     
	      String buildDomain="";
	      int cnt=0;
	      for(int j=domainSplit.length-1; j >=0; j--)
	      {
	        
	        // test.yahoo.com
	      if(cnt==0)
	      {
	        buildDomain=domainSplit[j];
	      }
	        else{
	            buildDomain=domainSplit[j] + "." + buildDomain;
	          
	        }
	      
	       // System.out.println(buildDomain);
	        if(map.containsKey(buildDomain))
	        {
	           int count=map.get(buildDomain);
	          count=count+ Integer.parseInt(arr[0]);
	           map.put(buildDomain, count );
	         // System.out.println("Count "+count);
	          
	        }
	        else{
	          
	          map.put(buildDomain, Integer.parseInt(arr[0]) );
	        }
	        
	       cnt++;
	        
	        
	      }
	      
	      
	    }
	    
	    
	    return map;
	    
	    
	    
	    
	  }
	  

}
