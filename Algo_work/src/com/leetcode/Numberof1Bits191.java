package com.leetcode;

/**
 * 
 * 191. Number of 1 Bits
Easy

375

344

Favorite

Share
Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

 

Example 1:

Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:

Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
Example 3:

Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 

Note:

Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 

Follow up:

If this function is called many times, how would you optimize it?
 * 
 * 
 * @author RAgarwal
 *
 */

public class Numberof1Bits191 {

	public int hammingWeight(int n) {
        // Converting to binary if, Hexa -toHexString if provided 16, octa if 8 -toOctalString
         System.out.println("n -->"+n);
          String binaryConversion= Integer.toBinaryString(n);
         
      
        System.out.println(binaryConversion);
        char bitArr[]= binaryConversion.toCharArray();

        int oneCount=0;
        for(int i=0; i< bitArr.length; i++)
        {
            // System.out.println(bitArr[i]);
            if(bitArr[i]=='1')
                oneCount++;
        }
        
        return oneCount;
    }
	
	public int hammingWeight2(int n) {
        // Converting to binary if, Hexa -toHexString if provided 16, octa if 8 -toOctalString
         System.out.println("n -->"+n);
         // String binaryConversion= Integer.toBinaryString(n);
         String binaryConversion= intToBinary(n);
      
        System.out.println(binaryConversion);
        char bitArr[]= binaryConversion.toCharArray();

        int oneCount=0;
        for(int i=0; i< bitArr.length; i++)
        {
           //  System.out.println(bitArr[i]);
            if(bitArr[i]=='1')
                oneCount++;
        }
        
        return oneCount;
    }
	
	public static String intToBinary(int n)
	{
	    String s = "";
	    while (n > 0)
	    {
	        s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
	        n = n / 2;
	    }
	    return s;
	}
	
	
	public int hammingWeightWithBitOperation(int n) {
	       
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numberof1Bits191 n=new Numberof1Bits191();
		
		// sending int number of 00000000000000000000000000001011
		System.out.println("Result is -->" +n.hammingWeight(11));
		System.out.println("Result is -->" +n.hammingWeight2(11));
		System.out.println("Result is -->" +n.hammingWeightWithBitOperation(11));
	}

}
