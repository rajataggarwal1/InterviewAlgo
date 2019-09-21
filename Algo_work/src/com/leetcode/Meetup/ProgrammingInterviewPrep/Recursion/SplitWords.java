package com.leetcode.Meetup.ProgrammingInterviewPrep.Recursion;
/*
 * Given an input string like "bedbathbeyond" or "theredress", and a dictionary of valid english words,
 *  print a boolean indicating if it can be split into valid english words. 
 *  As an added exercise, print all the different ways in which the input may be split into valid english words. 
 *   For example "theredress" may be split as "the" "redress" or "there" "dress".

 * 
 */
import java.util.HashSet;
import java.util.Arrays;


public class SplitWords {
	
	public static boolean splitWords(String word, HashSet<String> dictionary) {
		if (word.isEmpty() || dictionary.contains(word))
			return true;
		for (int i =1; i< word.length(); i++) {
			if (splitWords(word.substring(0, i), dictionary) && splitWords(word.substring(i, word.length()), dictionary)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		
		System.out.println(splitWords("abc", new HashSet<String>(Arrays.asList("a", "b", "c"))));
		System.out.println(splitWords("abbc", new HashSet<String>(Arrays.asList("a", "b", "c"))));
		System.out.println(splitWords("abbc", new HashSet<String>(Arrays.asList("abb", "ab", "bc"))));
		System.out.println(splitWords("abbc", new HashSet<String>(Arrays.asList("abb", "ab", "c"))));
		System.out.println(splitWords("abbc", new HashSet<String>(Arrays.asList("abb", "ab", "bbc"))));
	}

}