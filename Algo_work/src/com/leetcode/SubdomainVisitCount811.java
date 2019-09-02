package com.leetcode;
/*
 * 811. Subdomain Visit Count
Easy

299

459

Favorite

Share
A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".

We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.

Example 1:
Input: 
["9001 discuss.leetcode.com"]
Output: 
["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
Explanation: 
We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.

Example 2:
Input: 
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output: 
["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
Explanation: 
We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.

Notes:

The length of cpdomains will not exceed 100. 
The length of each domain name will not exceed 100.
Each address will have either 1 or 2 "." characters.
The input count in any count-paired domain will not exceed 10000.
The answer output can be returned in any order.
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount811 {

	 public List<String> subdomainVisits(String[] domain) {
	        
	        HashMap<String, Integer> map=new HashMap<String, Integer>();
		     // System.out.println(domain.length);
		    for(int i=0; i< domain.length; i++)
		    {
		      String arr[]= domain[i].split(" ");
		    //  System.out.println(arr[0] + " " + arr[1]);
		      
		      String domainSplit[]=arr[1].split("\\.");
		     
		      String buildDomain="";
		      int cnt=0;
		      for(int j=domainSplit.length-1; j >=0; j--)
		      {	        
		        // building domain to copy into map so that we will have counter
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
		    
	         // returning list
	         List<String> returnList=new ArrayList<String>();
	         
	         for(Map.Entry<String, Integer> entries:map.entrySet())
	            {
	             String str=entries.getValue() + " " + entries.getKey();
	              //System.out.println(entries.getValue() + " : " + entries.getKey());
	             returnList.add(str);
	            }
	         
		    
		    return returnList;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SubdomainVisitCount811 s= new SubdomainVisitCount811();
		String[] counts = {  
				"900 google.com",
			      "60 mail.yahoo.com",
			      "10 mobile.sports.yahoo.com",
			      "40 sports.yahoo.com",
			      "300 yahoo.com",
			      "10 stackoverflow.com",
			      "20 overflow.com",
			      "2 en.wikipedia.org",
			      "1 m.wikipedia.org",
			      "1 mobile.sports",
			      "1 google.co.uk"
			    };
		
		List<String> result=s.subdomainVisits(counts);
		
		System.out.println(result.toString());
		/*
		 * Example 1:
			Input: 
			["9001 discuss.leetcode.com"]
			Output: 
			["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
		 * 
		 */
		String[] counts1 = { "9001 discuss.leetcode.com"}; 
			result=s.subdomainVisits(counts1);
		
			System.out.println(result.toString());
		
		
	}
	
	
	

}
