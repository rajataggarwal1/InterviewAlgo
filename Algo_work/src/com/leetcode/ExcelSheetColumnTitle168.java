package com.leetcode;

/*
 * 
 * https://leetcode.com/problems/excel-sheet-column-title/
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
 * 
 */

public class ExcelSheetColumnTitle168 {
		
	public String convertToTitle(int n) {
        
		String alpha="abcdefghijklmnopqrstuvwxyz";
		String resultStr="";
		int modval=n;
		int divideval=n;
		
		while(true)
		{
			modval=(divideval-1)%26;
			divideval=(divideval-1)/26;
			
			if(modval >=0 && modval<26) // checking if mode is inbetween 1-26 so that can get character to print
			{
				resultStr=alpha.charAt(modval)+ resultStr  ;
			}
			
			if(divideval==0)
			{				
					break;
			}
				
		}
		
        return resultStr.toUpperCase();
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnTitle168 e= new ExcelSheetColumnTitle168();
		
		System.out.println(e.convertToTitle(0));	
		System.out.println(e.convertToTitle(5));	
		System.out.println(e.convertToTitle(25));
		
		System.out.println(e.convertToTitle(26));
		
		System.out.println(e.convertToTitle(27));	
			
		
		System.out.println(e.convertToTitle(701));	
		System.out.println(e.convertToTitle(703));	
		System.out.println(e.convertToTitle(6961));	
	}

}
