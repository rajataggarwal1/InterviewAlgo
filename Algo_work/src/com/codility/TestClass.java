package com.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TestClass {

	/**
	 * @param args
	 */
	
	int solution(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += A[i];
        }
        return ans;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestClass sp=new TestClass();
		
		
		//int arr1[]= {1, 3, 6, 4, 1, 2};
		int arr1[]= {6,5,3,4,1,-7};
		//int arr1[]= {1,2,3};
		//int arr1[]= {-1,-2};
		//int arr1[]= {};
		
		
		int result=sp.solution(arr1);
		
		System.out.println(result);
		
	}

}
