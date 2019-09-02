package com.InterviewGiven.Questions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Design an api rate limiter with the following features:
- Limits the given example whichSuperHeroAmI api calls to 5 per user per minute
- Returns proper error/success message
 
 -- This rolling window and 5 request per user in one minute timeframe.
 * 
 * 
 */

public class SuperHeroAPI_ThomasEyeInterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperHeroAPI superhero = new SuperHeroAPI();
		
		
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    
	    System.out.println("****************************************");
	    
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    
	    System.out.println("****************************************");
	    
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    
	    System.out.println("****************************************");
	    
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    System.out.println(superhero.whichSuperHeroAmI("A"));
	    
	    System.out.println("****************************************");
	    
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    
	    System.out.println("****************************************");
	    
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    System.out.println(superhero.whichSuperHeroAmI("B"));
	    
	    

		
		

	}

}



//custom claa which will store the details about the call

class RateLimiter{

long startTime;
 //
String userName;

RateLimiter(long startTime, String userName)
{
 this.startTime=startTime;
 this.userName=userName;
}



}



class SuperHeroAPI {


Map<String, List<RateLimiter>>  userMap=new HashMap<String, List<RateLimiter>>();


 String[] superheroes = {"Ant-Man", "Aquaman", "Asterix", "The Atom", "The Avengers", "Batgirl", "Batman", "Batwoman", "Black Canary", "Black Panther", "Captain America", "Captain Marvel", "Catwoman", "Conan the Barbarian", "Daredevil", "The Defenders", "Doc Savage", "Doctor Strange", "Elektra", "Fantastic Four", "Ghost Rider", "Green Arrow", "Green Lantern", "Guardians of the Galaxy", "Hawkeye", "Hellboy", "Incredible Hulk", "Iron Fist", "Iron Man", "Marvelman", "Robin", "The Rocketeer", "The Shadow", "Spider-Man", "Sub-Mariner", "Supergirl", "Superman", "Teenage Mutant Ninja Turtles", "Thor", "The Wasp", "Watchmen", "Wolverine", "Wonder Woman", "X-Men", "Zatanna", "Zatara"};
 public String whichSuperHeroAmI(String userName) {
   
   
   
   // Call method to check the validity
	 	if(checkUser(userName))
      {
   
	     int index = (int)(Math.random()*(superheroes.length+1));
	     if(index > superheroes.length)
	     {
	    	 index=(int)(Math.random()*(superheroes.length-1));
	     }
	     
	     return superheroes[index];
      }
      else
      {
        return "No user to print";
      }
 }

// User Name
// Timer
//


public boolean checkUser(String userName)
{
 
 // check in the Map whether it exist or not
 
	 if(userMap.containsKey(userName))
	 {
	   
	   ArrayList<RateLimiter> lst=(ArrayList<RateLimiter>)userMap.get(userName);
	   //enter 3600 for one minute
	   
	   long oneMinAgoTime=Instant.now().minusSeconds(100).toEpochMilli();
	   
	       
	   
	   if(lst.size() == 5)
	   {
	      for(int i=0; i<5; i++)
	      {
	        
	        RateLimiter rl=lst.get(i);
	        
	        if(rl.startTime < oneMinAgoTime)
	        {
	          lst.remove(i);            
	          
	        }
	        
	      }
	     
	     if(lst.size()==5)
	     {
	       return false;
	     }
	     else
	     {
	       
	       RateLimiter rl1=new RateLimiter(Instant.now().toEpochMilli(), userName);
	       lst.add(rl1);          
	       userMap.put(userName, lst);
	       return true;
	     }
	     
	     
	   }
	   else
	   {
		   RateLimiter rl1=new RateLimiter(Instant.now().toEpochMilli(), userName);
	       lst.add(rl1);          
	       userMap.put(userName, lst);
	       return true;
	   }
	   
	 }
	 else
	 {
	       RateLimiter rl1=new RateLimiter(Instant.now().toEpochMilli(), userName);
	      
	       List<RateLimiter> list=new ArrayList<RateLimiter>();
	       list.add(rl1);          
	       userMap.put(userName, list);
	       return true;
	   
	 }
 
 //return true;
 
 //Instant.now().toEpochMilli()
 // RateLimiter rateLimiter=new RateLimiter(Instant.now().toEpochMilli(), userName);
 
 
 
 
}


}
