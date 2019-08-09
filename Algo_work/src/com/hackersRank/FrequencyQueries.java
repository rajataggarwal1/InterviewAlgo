package com.hackersRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Frequency Queries
You are given queries. Each query is of the form two integers described below:
- : Insert x in your data structure.
- : Delete one occurence of y from your data structure, if present.
- : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.
The queries are given in the form of a 2-D array of size where contains the
operation, and contains the data element. For example, you are given array
. The results of each operation are:
Operation Array Output
(1,1) [1]
(2,2) [1]
(3,2) 0
(1,1) [1,1]
(1,1) [1,1,1]
(2,1) [1,1]
(3,2) 1
Return an array with the output: .
Function Description
Complete the solve function in the editor below. It must return an array of integers where each element is
a if there is at least one element value with the queried number of occurrences in the current array, or 0
if there is not.
solve has the following parameter(s):
queries: a 2-d array of integers
Input Format
The first line contains of an integer , the number of queries.
Each of the next lines contains two integers denoting the 2-d array .
Constraints
All
Output Format
Return an integer array consisting of all the outputs of queries of type .
Sample Input 0
8
1 5
1 6
3 2
1 10
1 10
1 6
2 5
3 2
Sample Output 0
0
1
Explanation 0
For the first query of type , there is no integer whose frequency is ( ). So answer is .
For the second query of type , there are two integers in whose frequency is
(integers = and ). So, the answer is .
Sample Input 1
4
3 4
2 1003
1 16
3 1
Sample Output 1
0
1
Explanation 1
For the first query of type , there is no integer of frequency . The answer is .
For the second query of type , there is one integer, of frequency so the answer is .
Sample Input 2
10
1 3
2 3
3 2
1 4
1 5
1 5
1 4
3 2
2 4
3 2
Sample Output 2
0
1
1
Explanation 2
When the first output query is run, the array is empty. We insert two 's and two 's before the second
output query, so there are two instances of elements occurring twice. We delete a and
run the same query. Now only the instances of satisfy the query.
 * 
 */

public class FrequencyQueries {

	/**
	 * @param args
	 */
	
	// Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {

List lst= new ArrayList<Integer>();
List<Integer> returnList= new ArrayList<Integer>();
Map<String, Integer> resultMap= new HashMap();

int opType=0;
String value;
int valcount=0;

	for (int i=0; i<queries.size(); i++ )
	{
	    lst= queries.get(i);
	    opType=Integer.parseInt(lst.get(0).toString());
	    value=lst.get(1).toString();
	
	    if(opType==1)
	    {
	         if(resultMap.containsKey(value)== true)
	        {
	            valcount= Integer.parseInt(resultMap.get(value).toString());
	            if(valcount > 0)
	            {
	            valcount++;
	            resultMap.put(value, valcount);
	            }
	        }        
	        else
	        {
	        	resultMap.put(value, 1);
	        }
	    }
	    else if(opType==2)
	    {
	        if(resultMap.containsKey(value)== true)
	        {
	        	valcount= Integer.parseInt(resultMap.get(value).toString());
	             if(valcount > 0)
	            {
	                valcount--;
	                resultMap.put(value, valcount);
	
	            }
	            else
	            {
	            	resultMap.remove(value);
	            }
	        }
	
	    } 
	    else
	    {
	    	
	    	int result=0;
	    	
	    	
	    	
	    		    	
	    		for (Map.Entry entry :resultMap.entrySet()) 
	    		{
	    		   // System.out.println(entry.getKey() + " = " + entry.getValue());
	    		
	    		
					valcount=  Integer.parseInt(entry.getValue().toString());
				    if(valcount == Integer.parseInt(value))
				   {
				       result=1;
				       break;
				   }
				   else
				   {
				       result=0;;
				   }
	    	}
	
	      returnList.add((Integer)result);
	        
	
	        
	    }
	}
	
	return returnList;
}
	
	

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<List<Integer>>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<Integer>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(String.valueOf(ans.get(i)));

           
        }
/*
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }

}
