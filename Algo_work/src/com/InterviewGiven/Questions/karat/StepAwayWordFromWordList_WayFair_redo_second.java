package com.InterviewGiven.Questions.karat;

/*
https://public.karat.io/content/q093/wordlist.txt

Given two strings s1 and s2, we will call (s1, s2) a "step" if you can form s2 by adding exactly one letter to s1 and possibly rearranging the letters of s1.

For example:
(of, for) is a step
(of, if) is not a step
(of, oct) is not a step
(era, ear) is not a step

Given the 1000-word wordlist we just generated, produce an index
   w -> {  w1 | (w, w1) is a step } 
that associates to each word all the words in the wordlist that are a step away from it.

index = step_index(wordlist)

# Expected output (pseudocode):

index['ERA'] = ['REAL', 'RARE', 'AREA', 'READ', 'RATE', 'BEAR', 'NEAR', 'RACE', 'HEAR', 'YEAR', 'DEAR', 'FEAR', 'CARE']


index['JOY'] = []

// Approach
int count[]= new int[26];

for( to the stringlength)
count[charAt(i)  - 'a']
map(key as char, val as count)

*/

public class StepAwayWordFromWordList_WayFair_redo_second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
