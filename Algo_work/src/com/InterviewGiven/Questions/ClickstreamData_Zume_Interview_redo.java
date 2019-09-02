package com.InterviewGiven.Questions;

/*
 * // We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order and no URL was visited more than once per person.

// Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

// Sample input:

// user0 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
// user1 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
// user2 = ["a", "/one", "/two"]
// user3 = ["/red", "/orange", "/yellow", "/green", "/blue", "/purple", "/white", "/amber", "/HotRodPink", "/BritishRacingGreen"]
// user4 = ["/red", "/orange", "/amber", "/green", "/blue", "/purple", "/white", "/lavender", "/HotRodPink", "/BritishRacingGreen"]
// user5 = ["a"]

// Sample output:

// findContiguousHistory(user0, user1)
//    /pink
//    /register
//    /orange

// findContiguousHistory(user1, user2)
//    (empty)

// findContiguousHistory(user2, user0)
//    a 

// findContiguousHistory(user5, user2)
//    a 

// findContiguousHistory(user3, user4)
//    /green
//    /blue
//    /purple
//    /white

// findContiguousHistory(user4, user3)
//    /green
//    /blue
//    /purple
//    /white


 //user0 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
// user1 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]


// loop thru user0
// HashSet  /start
 * 
 * 
 */


public class ClickstreamData_Zume_Interview_redo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] user0 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
		    String[] user1 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
		    String[] user2 = {"a", "/one", "/two"};
		    String[] user3 = {"/red", "/orange", "/yellow", "/green", "/blue", "/purple", "/white", "/amber", "/HotRodPink", "/BritishRacingGreen"};
		    String[] user4 = {"/red", "/orange", "/amber", "/green", "/blue", "/purple", "/white", "/lavender", "/HotRodPink", "/BritishRacingGreen"};
		    String[] user5 = {"a"};

	}
	
	
	public void findContiguousHistory(String user1, String user2)
	{
		
		
	}

}
