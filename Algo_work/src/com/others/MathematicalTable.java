package com.others;

// print matematical table using recursion

public class MathematicalTable {

	void printTable(int n) {
		
		printTableHelper(n, 1);	
		
	}
	
	private void printTableHelper(int n, int toMultiply) {
		
		if(toMultiply > 10)
			return;
		
		System.out.println(n*toMultiply);
		
		printTableHelper(n, toMultiply+1);	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathematicalTable m=new MathematicalTable();
		m.printTable(3);
	}

}
