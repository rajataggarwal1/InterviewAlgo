package com.leetcode;
/*
 * 344. Reverse String
Easy

677

426

Favorite

Share
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ['h','e','l','l','o']
Output: ['o','l','l','e','h']
Example 2:

Input: ['H','a','n','n','a','h']
Output: ['h','a','n','n','a','H']
 * 
 * 
 * 
 */
public class ReverseString344 {
public void reverseString(char[] s) {
        
        int len= s.length;
        
        char temp;
        
        for(int i=0, j= len-1; i<=j;i++,j-- )
        {
            
            temp=s[i];
            
            
            s[i]=s[j];
            s[j]=temp;
            
            
            
               
        }
        
}
        
        public void reverseStringWithoutVariable(char[] s) {
            
            int len= s.length;
            
            char temp;
            
            for(int i=0, j= len-1; i<=j;i++,j-- )
            {
                
             //   temp=s[i];
                
            	 System.out.println(s[i]);
                s[i] = (char) (s[i] + s[j]); // x now becomes 15 
                System.out.println(s[i]);
                s[j] = (char) (s[i] - s[j]); // y becomes 10 
                System.out.println(s[j]);
                s[i] = (char) (s[i] - s[j]);
                System.out.println(s[i]);
                
                
               /* int a=a  ^ s[i];
                System.out.println(a);
                		int b=a ^ b;
                		System.out.println(b);
                		int c=a ^ b;
                		System.out.println(c);
                
                
                s[i]=s[j];
                s[j]=temp;*/
                
                
                
                
                /*
                 * a=a  xor b
    b=a xor b
    c=a xor b
                 */
                
            }
            
            for(int i=0;  i<s.length;i++ )
            {
                
               
                System.out.print(s[i]);
               
                
                
            }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
char ch[]= {'h','e','l','l','o'};


ReverseString344 r=new ReverseString344();

r.reverseString(ch);
r.reverseStringWithoutVariable(ch);
	}

}
