package com.InterviewGiven.Questions;
/*
 * 
Implement a Cache which has the following interface :

interface Cache {
  void put(String key,  String value);
  String get(String key);
 void remove(String key);
}

The cache eviction strategy should be LFU - Least frequently used.
An item which has the least number of gets should be the one to be removed if the cache runs out of capacity


Usage :

Cache cache= new CacheImpl ( 2 );
cache.put("a", "v1");
cache.put("b", "v2");
cache.get("a");
cache.get("a");
cache.get("b");
cache.put("c", "v2");	// removes b

// Create a class string key, val, count
// HashMap -> key will key, val object of class
// sorting based on the count value
// check for the key and the count
 * 
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class CacheClass
{
   String key;
   String val;
   int count;
   
   CacheClass(String key,String val , int count)
   {
     
     this.key=key;
     this.val=val;
     this.count=count;
     
   }
  
  
}

class SortByVal implements Comparator
{
  @Override
  public int compare(Object obj1, Object obj2)
  {
    
    CacheClass ch1=(CacheClass)obj1;
    CacheClass ch2=(CacheClass)obj2;
    
    if(ch1.count > ch2.count)
    {
      return -1;
    }
    else if(ch1.count < ch2.count)
    {
      return 1;
      
    }
    else
    {
      return 0;
    }
    
    
  }
  
  
  
}
public class LeastFrequentlyUsed_PaloAltoNetworks {

	private int size;
	  
	  public LeastFrequentlyUsed_PaloAltoNetworks(int size)
	  {
	    this.size=size;
	    
	  }
	  
		public static void main (String[] args) {
			System.out.println("Hello Java");
	    
			LeastFrequentlyUsed_PaloAltoNetworks cache= new LeastFrequentlyUsed_PaloAltoNetworks( 2 );
	    cache.put("a", "v1");
	    cache.put("b", "v2");
	    cache.put("c", "v3");
	    
	    System.out.println(cache.get("a"));
	    System.out.println(cache.get("a"));
	    System.out.println(cache.get("b"));
	    cache.put("c", "v3");
	    
	    System.out.println(cache.get("c"));
	    
	    
	    
		}
	  
	  Map<String, CacheClass> map=new HashMap<String, CacheClass>();
	  
	 
	 public  void put(String key, String value)
	  {
	    
	    int currCapicity=map.size();
	    
	    if(currCapicity < size)
	    {
	      
	      if(map.containsKey(key))
	      {
	         CacheClass ch= (CacheClass)map.get(key);
	         
	         ch.count=ch.count+1;
	         map.put(key,ch);
	         
	      }
	      else{
	         CacheClass ch=new CacheClass(key,value,1 );
	          map.put(key,ch);
	      }   
	    }
	    else{
	      
	    	ArrayList<CacheClass>  list= new ArrayList<CacheClass>();
	      
	      for(Map.Entry entries: map.entrySet())
	      {
	        list.add((CacheClass)entries.getValue());    
	        
	      }
	      
	      Collections.sort(list, new SortByVal());
	      
	      CacheClass ch2=(CacheClass)list.get(0);
	     map.remove(ch2.key);
	      CacheClass ch3=new CacheClass(key,value,1 );
	          map.put(key,ch3);
	    }
	    
	     
	    
	  }
	public String get(String key)
	  {
	    String rmessage="";
	    
	     if(map.containsKey(key))
	      {
	         CacheClass ch= (CacheClass)map.get(key);
	         
	         ch.count=ch.count+1;
	         
	         rmessage=ch.val;
	         map.put(key,ch);
	         
	      }
	      
	      return rmessage;
	      
	  }
	 public void remove(String key)
	 {
	   
	    if(map.containsKey(key))      
	      map.remove(key);
	   
	    
	   
	 }

}
