package com.leetcode;
/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 * 
 */

public class ValidPalindrome125 {
	 public boolean isPalindrome(String s) {
	        
	        int length= s.length();
	        s=s.toLowerCase();
	        boolean isValidPalindrome=true;
	        
	        for (int i=0, j=length-1; i<=j ;)
	        {
	            
	            if(isAlphaNumeric(s.charAt(i)) && isAlphaNumeric(s.charAt(j)))
	               {
	                   if(s.charAt(i)==s.charAt(j))
	                   {
	                	   if(i==j || i+1==j)
	                	   {
	                           isValidPalindrome=true;
	                           break;
	                	   }
	                       i++;
	                       j--;
	                      
	                   }
	                   else
	                   {
	                       isValidPalindrome=false;
	                       break;
	                   }
	               }
	               else
	               {
	                   if(!isAlphaNumeric(s.charAt(i)))
	                   {
	                       i++;
	                   }
	                   else if(!isAlphaNumeric(s.charAt(j)))
	                           {
	                                j--;
	                           }
	                          
	               }
	            
	        }
	        
	        
	        return isValidPalindrome;
	    }
	    
	    public boolean isAlphaNumeric(char c)
	    {
	        int charTocheck=c;
	         if((charTocheck-'a' >= 0 && charTocheck-'a' <=26) ||( charTocheck-'0' >=0 && charTocheck-'0'<= 9) )
	            return true;
	        else
	            return false;
	        
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome125 v=new ValidPalindrome125();
		System.out.println(v.isPalindrome(""));
		System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(v.isPalindrome("Abba"));
		System.out.println(v.isPalindrome("race a car"));
	}

}
