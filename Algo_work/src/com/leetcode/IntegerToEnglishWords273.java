package com.leetcode;

import java.util.HashMap;

/*
 * 273. Integer to English Words
Hard
https://leetcode.com/problems/integer-to-english-words/
491

1292

Favorite

Share
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * 
 * 
 * 
 */
public class IntegerToEnglishWords273 {
	public String numberToWords(int num) {
        HashMap map=new HashMap();
        
        map.put(1,"One");
        map.put(2,"Two");  
        map.put(3,"Three"); 
        map.put(4,"Four");
        map.put(5,"Five");
          map.put(6,"Six");
          map.put(7,"Seven");
          map.put(8,"Eight");
          map.put(9,"Nine");
          map.put(10,"Ten");
        map.put(11,"Eleven");
          map.put(12,"Twelve");
          map.put(13,"Thirteen");
          map.put(14,"Forteen");
          map.put(15,"Fifteen");
        map.put(16,"Sixteen");
          map.put(17,"Seventeen");
          map.put(18,"Eighteen");
          map.put(19,"Ninteen");
          map.put(20,"Twenty");
        map.put(30,"Thirty");
          map.put(40,"Forty");
          map.put(50,"Fifty");
          map.put(60,"Sixty");
          map.put(70,"Seventy");
        map.put(80,"Eighty");
          map.put(90,"Ninety");
          map.put(100,"Hundred");
          map.put(1000,"Thousand");
          map.put(1000000,"Million");
        map.put(1000000000,"Billion");
        
        String returnStringMain="";
        int modeval=0;
        if(num ==0)
        {
              
            return "Zero";
        }
        if(num > 0 && num <= 20)
        {
            returnStringMain=(String)map.get(num);
            return returnStringMain;
        }
        
        while(num>0)
        {
           
            if(num>0 && num<100)
            {
                //mode with 10
                returnStringMain =returnStringMain + upToHunconvert(map,num);
                 modeval=num%10;
                
                int tempNum=num-modeval;
                 num=tempNum%10;
                
            }
            else if(num>=100 && num<1000 )
            {
                //mode with 100
              //   modeval=num%100;
                
                returnStringMain =returnStringMain + upToThousandconvert(map,num);
              // num=modeval;
                num=0;
            }
            else if(num>=1000 && num<1000000 )
            {
                //mode with 1000
               
                modeval=num%1000;
                
                int tempNum=num-modeval;
                  tempNum=tempNum/1000;
                
                    if(tempNum>0 && tempNum<100)
                    {
                       returnStringMain =returnStringMain +  upToHunconvert(map,tempNum);
                    }
                    else if(tempNum>=100 && tempNum<1000 )
                    {
                         returnStringMain =returnStringMain + upToThousandconvert(map,tempNum);
                    }
               
                returnStringMain+= (String) map.get(1000) +" ";
                
                
                //System.out.println("returnStringMain 1000 "+ returnStringMain);
                num=modeval;
                //returnStringMain =returnStringMain +  upToHunconvert(map,modeval);
               // num=0;
                
            }
            else if(num>=1000000 && num<1000000000 )
            {
                //mode with 1000000
        		modeval=num%1000000;
                
                int tempNum=num-modeval;
                tempNum=tempNum/1000000;
                
                    if(tempNum>0 && tempNum<100)
                    {
                       returnStringMain =returnStringMain +  upToHunconvert(map,tempNum);
                    }
                    else if(tempNum>=100 && tempNum<1000 )
                    {
                         returnStringMain =returnStringMain + upToThousandconvert(map,tempNum);
                    }
                    
               
                returnStringMain+= (String) map.get(1000000) +" ";
                
                
             //   System.out.println("returnStringMain milin "+ returnStringMain);
                num=modeval;
            }
            else if(num>=1000000000 && num <= Integer.MAX_VALUE )
            {
            	modeval=num%1000000000;
                
                int tempNum=num-modeval;
                tempNum=tempNum/1000000000;
                
                    if(tempNum>0 && tempNum<100)
                    {
                       returnStringMain =returnStringMain +  upToHunconvert(map,tempNum);
                    }
                    else if(tempNum>=100 && tempNum<1000 )
                    {
                         returnStringMain =returnStringMain + upToThousandconvert(map,tempNum);
                    }
                    
               
                returnStringMain+= (String) map.get(1000000000) +" ";
                
                
             //   System.out.println("returnStringMain bil "+ returnStringMain);
                num=modeval;
            }
            
        }
        
        return returnStringMain;

    }
        public String upToHunconvert(HashMap map,int num)
        {
             String  returnString="";
            if(num > 0 && num < 20)
            {
                returnString=(String)map.get(num)+ " ";
                return returnString;
            }
            
            int modeval=num%10;
                
            int tempNum=num-modeval;
            returnString= returnString +  (String)map.get(tempNum) + " ";
            if(modeval > 0)
            {
            	returnString+=  (String)map.get(modeval) + " ";
            }
            return returnString;
        }
        
        public String upToThousandconvert(HashMap map,int num)
        {
           String  returnString="";
           int  modeval=num%100;
           int tempNum=num-modeval;
           		
           		tempNum=tempNum/100;
                returnString+=  (String)map.get(tempNum) + " ";
                returnString+=  (String)map.get(100) + " ";
               
               if(modeval > 0)
               {
            	   returnString+=upToHunconvert(map,modeval);
               }
            return returnString;
        }
        
      
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToEnglishWords273 i=new IntegerToEnglishWords273();
		System.out.println(i.numberToWords(2147483647));
		/* System.out.println(i.numberToWords(934567));
		 System.out.println(i.numberToWords(123));*/
		 System.out.println(i.numberToWords(123934567));
		System.out.println(i.numberToWords(1234567891)); 
	}

}
