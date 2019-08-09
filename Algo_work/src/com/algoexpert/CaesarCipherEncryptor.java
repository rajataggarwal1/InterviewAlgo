package com.algoexpert;

public class CaesarCipherEncryptor {

	public static String caesarCypherEncryptor(String str, int key) {
	    // Write your code here.
			char ch[]=str.toCharArray();
			String returnString="";
			for(int i=0; i< ch.length; i++)
			{
				int charTonum=ch[i]-'a';
				 int addToChar=(charTonum+key)%26;
				 
				 
				 
				 charTonum='a'+ addToChar;
				 
				ch[i]= (char)charTonum;
				
				System.out.print(ch[i]);
				
				
				returnString+=ch[i];
				
			}
			
			return returnString;
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CaesarCipherEncryptor c=new CaesarCipherEncryptor();
		System.out.println(c.caesarCypherEncryptor("xyz",2));

	}

}
