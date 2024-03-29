package com.leetcode.Meetup.ProgrammingInterviewPrep.Graph;
/*
 *  There are 10 poles infinitely long, and there is a fruit at some  distance on one of the 10 poles.  
 
  If you are programming a monkey-bot, how would you go about fetching the fruit. 
  
  The poles are infinitely long, so you will never reach the end of a pole. 
  You cannot hop from pole to pole, but can climb down a pole after climbing a certain distance,
   and then pick another pole to climb up. 
  
  The method sawFruit() will return true once the monkey-bot touches or passes the fruit.
 */
 
public class FetchFruit {

	//pseudo-code 
	void fetchFruitfromPole() {
	     // we know we will get to the fruit at some point
	     while (true) {
	       long heightToClimb = 1;
	         for (int i =0; i<10; i++) {
	             climbPole(i, heightToClimb);
	             if (sawFruit()) {
	                 eatFruit();
			 return;
	             }
	         }
	         heightToClimb  = heightToClimb * 2; 
	     }
	     
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
