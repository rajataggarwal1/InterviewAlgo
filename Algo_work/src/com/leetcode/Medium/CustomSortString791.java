package com.leetcode.Medium;

/*
 * https://leetcode.com/problems/custom-sort-string/
 * 791. Custom Sort String
Medium

454

138

Favorite

Share
S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 

Note:

S has length at most 26, and no character is repeated in S.
T has length at most 200.
S and T consist of lowercase letters only.
 * 
 * 
 * 
 */
public class CustomSortString791 {

	public String customSortString(String S, String T) {
	     
        // Solution is to first go thru second string and map the counter in the array of 26 size
        // then go thru the first pattern string and start building the result
        // Add all the element into return string if found in first and has more then one count.
        
        int tCount[]=new int[26];        
        int totalSchar=S.length();
      
        // building char counter from second string
        for(int i=0; i<T.length(); i++)
        {            
            tCount[T.charAt(i)-'a']= tCount[T.charAt(i)-'a']+1;    
        }
       // System.out.println(Arrays.toString(tCount));
        
        
       String returnString="";
        
        // Start building result by going thru first string. If found then build and use all the count from second
       for(int i=0; i< S.length(); i++)
       {
           // consuming all the lement
           while(tCount[S.charAt(i)-'a'] > 0)
           {
               returnString=returnString+S.charAt(i);
                tCount[S.charAt(i)-'a']--;
               
           }           
           
       }
         // System.out.println("* " +Arrays.toString(tCount));
   
        // Add remaining element to go thru secound string counter into return string.
        for(int i=0; i< 26; i++)
        {            
            if(tCount[i]>0)
            { 
                // counsuming all elemnt at given position
                while(tCount[i]>0)
                {
                    int a='a'+i;
                    char c=(char)a;
                    returnString=returnString+c;
                    tCount[i]--;
                } 
            }
        }
        
       return returnString; 
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomSortString791 s=new CustomSortString791();
		String S = "cba";
		String T = "abcd";
		
		System.out.println(s.customSortString(S, T));
		
		 S = "abckl";
		 T = "aabcdkpl";
		
		System.out.println(s.customSortString(S, T));

		S = "kqep";
		T = "pekeq";
		
		System.out.println(s.customSortString(S, T));

		
		
	}

}
