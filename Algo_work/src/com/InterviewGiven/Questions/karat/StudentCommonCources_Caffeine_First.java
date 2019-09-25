package com.InterviewGiven.Questions.karat;
/*
 * *Intuit also asked similar question
 * 
You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends.
 The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

Write a function that takes in a list of (student ID number, course name) pairs and returns,
 for every pair of students, a list of all courses they share.

Sample Input:

student_course_pairs_1 = [
  ["58", "Software Design"],
  ["58", "Linear Algebra"],
  ["94", "Art History"],
  ["94", "Operating Systems"],
  ["17", "Software Design"],
  ["58", "Mechanics"],
  ["58", "Economics"],
  ["17", "Linear Algebra"],
  ["17", "Political Science"],
  ["94", "Economics"],
  ["25", "Economics"],
]

Sample Output (pseudocode, in any order):

find_pairs(student_course_pairs_1) =>
{
  [58, 17]: ["Software Design", "Linear Algebra"]
  [58, 94]: ["Economics"]
  [58, 25]: ["Economics"]
  [94, 25]: ["Economics"]
  [17, 94]: []
  [17, 25]: []
}
  
Sample Input:

student_course_pairs_2 = [
  ["42", "Software Design"],
  ["0", "Advanced Mechanics"],
  ["9", "Art History"],
]

Sample output:
{9,42=[], 0,42=[], 0,9=[]}



find_pairs(student_course_pairs_1) =>
{
  [58, 17]: ["Software Design", "Linear Algebra"]
  [58, 94]: ["Economics"]
  [58, 25]: ["Economics"]
  [94, 25]: ["Economics"]
  [17, 94]: []
  [17, 25]: []
}
*/

/*
 * A Bit Better Approach

studentCoursePairs is essentially a student -> course mapping. Create the reverse one to many mapping, 
where a course is mapped to a list of students that are taking it. For each course in this map, the student list contains all 
the students that share the course. So you can loop over each course's student list and add to output all possible pairs of students.
 Again if a pair of student already exists in the output, add to that entry instead of creating a new one.

I leave the pseudo code (for now) up to the reader to imagine.

Creating the reverse mapping can be done by iterating over the studentCoursePairs once: O(size of studentCoursePairs).
The second part of this algo generates each shared course once, so it has O(number of shared courses). 
So overall O((size of studentCoursePairs) + (number of shared courses)).

Note that in the worst case of having all students taking the same course,
 the O(number of shared courses) = O((size of studentCoursePairs)2), and this algo has the same complexity as the brute force.
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class StudentCommonCources_Caffeine_First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] studentCoursePairs1 = {
			      {"58", "Software Design"},
			      {"58", "Linear Algebra"},
			      {"94", "Art History"},
			      {"94", "Operating Systems"},
			      {"17", "Software Design"},
			      {"58", "Mechanics"},
			      {"58", "Economics"},
			      {"17", "Linear Algebra"},
			      {"17", "Political Science"},
			      {"94", "Economics"},
			      {"25", "Economics"}
			    };

			    String[][] studentCoursePairs2 = {
			      {"42", "Software Design"},
			      {"0", "Advanced Mechanics"},
			      {"9", "Art History"},
			    };

			    
			    StudentCommonCources_Caffeine_First s=new StudentCommonCources_Caffeine_First();
			    
			  //  s.find_pairs(studentCoursePairs1);
			    Map<String, List<String>> result= s.getPairs(studentCoursePairs1);
			    System.out.println(" Result 1 ->" + result);
			    
			    System.out.println("**********************************");
			    Map<String, List<String>> result1= s.getPairs(studentCoursePairs2);
			    System.out.println("Result 2 -> " + result1);
			    	
	}
	
	public Map<String, List<String>> getPairs(String crs[][])
	{
		HashSet<String> uniqueSet=new HashSet<String>();
		Map<String, List<String>> idCourseMap = new HashMap<String, List<String>>();
		List<String> course;
		List<List<String>> returnList=new ArrayList<List<String>>();
	
		// Finding unique and mapping all course with unique student id 
		// in one iteration
		for(int i=0; i< crs.length; i++)
		{
			uniqueSet.add(crs[i][0]);
			
			if(idCourseMap.containsKey(crs[i][0]))
		      {
		        List<String> lst=(List)idCourseMap.get(crs[i][0]);
		        lst.add(crs[i][1]);
		        idCourseMap.put(crs[i][0], lst);  
		      }
		      else
		      {
		    	  course=new ArrayList<String>();
		    	  course.add(crs[i][1]);
		    	  idCourseMap.put(crs[i][0], course);
		      }			
		}
		
		System.out.println(uniqueSet);
		System.out.println("idCourseMap "+idCourseMap);
		
		// coverting set to object and then for later use of string to generate pair.
		
		Object[] arrSet=new Object[uniqueSet.size()];		
		arrSet=(Object[])uniqueSet.toArray();		
		
		// generate combination
		for(int i=0; i<arrSet.length; i++ )
		{
			for(int j=i+1; j< arrSet.length; j++)
			{
				List<String> tmpList=new ArrayList<String>();
				tmpList.add((String)arrSet[i]);
				tmpList.add((String)arrSet[j]);
				returnList.add(tmpList);				
			}				
		}
		System.out.println(returnList);
		
		
		
		// Now going thru the unique generated combination list and the course map to generate the result
		// Building result useing key in string and adding all common course in list and return map
		
		Map<String, List<String>> resultMap=new HashMap<String, List<String>>();
		
		for(int i=0; i<returnList.size(); i++)
		{
			// building key
			String first=returnList.get(i).get(0);
			String second=returnList.get(i).get(1);
			
			// Checking id mapped course 
			if(idCourseMap.containsKey(first) && idCourseMap.containsKey(second))
		      {
		        List<String> firstlst=(List)idCourseMap.get(first);
		        List<String> secondlst=(List)idCourseMap.get(second);
		        
		        String key= first + "," +second;
		        List<String> commonCourse=new ArrayList<String>();
		        
		        // finding intersection -> matching course
		        for(int k=0; k<firstlst.size(); k++)
		        {
		        	for(int l=0; l<secondlst.size(); l++)
		        	{
		        		if((firstlst.get(k)).equals(secondlst.get(l)))
		        		{
		        			commonCourse.add(firstlst.get(k));
		        		}
		        	}
		        }
		        // building result map
		        resultMap.putIfAbsent(key, commonCourse);
		      }			
			
		}
		
		System.out.println("resultMap "+resultMap);		
		
	
	return resultMap;
		
	}    
}
