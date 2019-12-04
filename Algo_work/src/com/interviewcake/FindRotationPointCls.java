package com.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;
import static org.junit.Assert.*;



class WordClass 
{
    String word;
    int index;
    
    WordClass(String word, int index)
    {
        this.word=word;
        this.index=index;
    }
}

class WordClassSorter implements Comparator<WordClass>
{
    @Override
    public int compare(WordClass w1, WordClass w2)
    {
        
         return w1.word.compareTo(w2.word); 
         
    }
    
}


public class FindRotationPointCls {

    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array
        
        PriorityQueue<WordClass> queue=new PriorityQueue<WordClass>(new WordClassSorter());
        
        for(int i=0; i< words.length; i++)
        {
        	WordClass ws=new WordClass(words[i], i);
            queue.add(ws);
            
        }
        
        WordClass wc=(WordClass)queue.poll();
        
        System.out.println(" word " + wc.word);
        System.out.println(" index " + wc.index);
        
        return wc.index;
    }


    // tests

    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[] {"cape", "cake"});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[] {"grape", "orange", "plum",
            "radish", "apple"});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
            new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
            "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void possiblyMissingEdgeCaseTest() {
        // are we missing any edge cases?
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FindRotationPointCls.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}