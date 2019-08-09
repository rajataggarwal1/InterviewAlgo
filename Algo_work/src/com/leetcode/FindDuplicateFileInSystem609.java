package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/*
 * 609. Find Duplicate File in System
Medium

215

357

https://leetcode.com/problems/find-duplicate-file-in-system/submissions/

Favorite

Share
Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their paths.

A group of duplicate files consists of at least two files that have exactly the same content.

A single directory info string in the input list has the following format:

"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

"directory_path/file_name.txt"

Example 1:

Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:  
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 

Note:

No order is required for the final output.
You may assume the directory name, file name and file content only has letters and digits, and the length of file content is in the range of [1,50].
The number of files given is in the range of [1,20000].
You may assume no files or directories share the same name in the same directory.
You may assume each given directory info represents a unique directory. Directory path and file info are separated by a single blank space.
 

Follow-up beyond contest:
Imagine you are given a real file system, how will you search files? DFS or BFS?
If the file content is very large (GB level), how will you modify your solution?
If you can only read the file by 1kb each time, how will you modify your solution?
What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming part of it? How to optimize?
How to make sure the duplicated files you find are not false positive?
 * 
 * 
 * 
 * 
 */
public class FindDuplicateFileInSystem609 {
	 public List<List<String>> findDuplicate(String[] paths) {
		 
	       List<List<String>> finalList=new ArrayList<List<String>>();
	       if(paths.length <1) 
	    	   return finalList;
	       
	       
	       HashMap<String,List> map=new HashMap<String,List>();
	        
	        
	        for(int i=0; i< paths.length; i++)
	        {

	        String pathArray[]=paths[i].split(" ");

	            for(int k=1; k<pathArray.length; k++)
	            {
	                String filePath=pathArray[0]+"/";
	                String keyPath="";
	                String str=pathArray[k];
	                char parenth=' ';
	                for(int j=0; j< str.length(); j++)
	                {
	                    if(str.charAt(j)=='(')
	                    {
	                        parenth='(';
	                        continue;                       
	                    }

	                    if(str.charAt(j)==')')
	                    {
	                        parenth=' ';
	                        if(map.containsKey(keyPath)!=true)
	                        {
	                            List<String> tempList=new ArrayList<String>();
	                            tempList.add(filePath);
	                            map.put(keyPath ,tempList );
	                        }
	                        else
	                        {
	                            List lst=(List)map.get(keyPath);
	                            lst.add(filePath);
	                            map.put(keyPath ,lst );
	                        }
	                        continue;

	                    }


	                    if(parenth == '(')
	                    {
	                        keyPath+=str.charAt(j);
	                    }
	                    else
	                    {
	                         filePath+=str.charAt(j);
	                    }
	                }
	            }
	        }
	        
	        if(map.size()>0)
	        {
	        	  Iterator<Entry<String, List>> itr = map.entrySet().iterator(); 
	              
	              while(itr.hasNext()) 
	              { 
	                   Entry<String, List> url = itr.next(); 
	                   System.out.println("Key = " + url.getKey() +  ", Value = " + url.getValue()); 
	                   
	                   if(url.getValue().size() <=1)
		                 {
	                	   // we can modify or remove element using Iterator
		                	itr.remove();
		                 }
		                 else
		                 {
		                	 finalList.add(url.getValue());
		                 }
	              } 
	        	
	        	
	        	/* It is throwing Exception in thread "main" java.util.ConcurrentModificationException because we are changing the hashmap value after assigning the iterator
	at java.util.HashMap$HashIterator.nextNode(Unknown Source)
	        	 *  for (Entry<String, List> url : map.entrySet())  
	        	 {
	        		// System.out.println("Key = " + url.getKey() + ", Value = " + url.getValue().size()); 
	                
	                 if(url.getValue().size() <=1)
	                 {
	                	 map.remove(url.getKey());
	                 }
	                 else
	                 {
	                	 finalList.add(url.getValue());
	                 }
	        	 }*/
	        	
	        }
	     return  finalList;  
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String paths[]= {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
		
	//String paths[]= {"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"};	
	
	FindDuplicateFileInSystem609 f=new FindDuplicateFileInSystem609();
		System.out.println(f.findDuplicate(paths));
	}

}
