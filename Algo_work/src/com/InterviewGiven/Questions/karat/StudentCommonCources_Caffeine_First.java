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
import java.util.List;

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
			    
			    s.find_pairs(studentCoursePairs1);
		
		

	}
	
	public List<List<String>> find_pairs(String student[][])
	  {
	    
	    if(student.length==0)
	    {
	      
	    }
	    
	    Map<String, List<String> > map = new HashMap<>();
	    List<String> crs;
	    
	    for(int i=0; i< student.length; i++)
	    {
	      if(map.containsKey(student[i][0]))
	      {
	        List<String> lst=(List)map.get(student[i][0]);
	        lst.add(student[i][1]);
	          map.put(student[i][0], lst);        
	        
	      }
	      else
	      {
	        crs=new ArrayList<String>();
	        crs.add(student[i][1]);
	        map.put(student[i][0], crs);
	      }
	      
	    }
	    
	    System.out.println(map);
	    
	   /* for(Map.Entry<String, List> entry:map.entrySet<String, List>())
	    {
	      
	      List<String> courseList=entry.getValue();
	      
	      while(courseList.size()>0)
	      {
	        
	        
	        
	        
	      }
	      
	      
	      
	    }*/
	    
	    
}
