package com.InterviewGiven.Questions;
/*
 * 
Given a string of characters, write a function that reverses the order of the characters while preserving the position of special characters.

I: a#b$cd!
O: d#c$ba!


-> go over the string from left and right
-> keep checking is non special then i will swap othewise i will just move to next


*/
 
public class ReverseStringOrder_Zillow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseStringOrder_Zillow s=new ReverseStringOrder_Zillow();
        String str="a#b$cd!";
        String result=s.reverseOrder(str);
        System.out.println(result);
        
        String str1="";
        result=s.reverseOrder(str1);
        System.out.println(result);
        
        String str2="!a";
         result=s.reverseOrder(str2);
        System.out.println(result);
        
        String str3="!aAbB#";
         result=s.reverseOrder(str3);
        System.out.println(result);
        
        String str4="!1Ab2#";
         result=s.reverseOrder(str4);
        System.out.println(result);
        
         String str5="!!!!!*****#";
          result=s.reverseOrder(str5);
        System.out.println(result);
         
          String str6="Test1ng-Leet=code-Q!";
           result=s.reverseOrder(str6);
        System.out.println(result);
        
        
        String str7=null;
        result=s.reverseOrder(str);
        System.out.println(result);
        
       // I: a#b$cd!
        //O: d#c$ba!

	}
	
	 public String reverseOrder(String input)
	  {
	      if(input == null)
	    	  return "";
	       
	      
	      if(input !=null && input.length()<=1)
	      {
	          return input;
	      }
	      
	      char []ch=input.toCharArray();
	      
	      
	     // System.out.println(ch-'1');
	      
	      int start=0;
	      int end=ch.length-1;
	      
	      while(start<end)
	      {
	          if(!isValid(ch[start]))
	          {
	              start++;
	              continue;
	          }
	          
	          if(!isValid(ch[end]))
	          {
	              end--;
	              continue;
	          }
	          
	          char temp=ch[start];
	          ch[start]=ch[end];
	          ch[end]=temp;
	          
	          start++;
	          end--;
	      }
	      
	      String result="";
	      for(int i=0; i< ch.length; i++)
	      {
	          result+=ch[i];
	      }
	      
	      return result;
	  }
	  
	  
	  boolean isValid(char ch)
	  {  
	      if((Character.toLowerCase(ch)-'a' >= 0 ||ch-'1' >= 0 ) && (Character.toLowerCase(ch)-'z' <= 26 || ch-'9' <= 9 ))
	      {
	          return true;
	      }
	      
	      return false;
	  }

}
