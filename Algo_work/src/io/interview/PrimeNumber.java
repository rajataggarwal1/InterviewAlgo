package io.interview;

import java.util.ArrayList;

/*
 * 
 * Print out all the prime numbers from 1 to 100. Keep it simple; you should pick a language you're comfortable with
 * 
 * */


public class PrimeNumber {

	public static void printPrime()
	  {
	    boolean primeFlag= false;
	    
	    for(int i=1; i<=100; i++)
	    {
	      primeFlag= true;
	      for (int num=2; num <= i/2; num++)
	      {
	        
	      if(i%num==0)
	      { 
	        primeFlag= false;
	        break;
	      }
	      
	      }
	      if(primeFlag == true)
	        System.out.println(i);
	      
	    }
	    
	  }
	  
	  
	  public static void main(String[] args) {
	    
	    
	    printPrime();
	    
	  }

}
